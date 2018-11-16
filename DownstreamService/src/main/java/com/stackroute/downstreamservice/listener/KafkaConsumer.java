package com.stackroute.downstreamservice.listener;


import com.stackroute.downstreamservice.domain.*;
import com.stackroute.downstreamservice.exceptions.EmployeeAlreadyExistsException;
import com.stackroute.downstreamservice.exceptions.EmployeeNotFoundException;
import com.stackroute.downstreamservice.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class KafkaConsumer {


    private EmployeeService employeeService;
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public KafkaConsumer(EmployeeService employeeService) {

        this.employeeService=employeeService;
    }

    @KafkaListener(topics = "${kafka.listeningTopic1}" ,groupId = "${kafka.groupId}",
    containerFactory="${kafka.containerFactory}")
    public void consumeJson(@Payload Employee employee) {
        Employee employee1=Employee.builder().userId(employee.getEmail())
                .email(employee.getEmail()).name(employee.getName())
                .build();
        if(logger.isDebugEnabled()) {
            logger.debug(String.format("${kafka.consumed}: %s", employee1));
        }
        try {
            employeeService.saveEmployee(employee1);
            logger.info("${kafka.success}");
        }catch (EmployeeAlreadyExistsException exception){
            logger.error(exception.getMessage());
        }catch(Exception exp){
            logger.error(exp.getMessage());
        }
    }

    @KafkaListener(topics = "${kafka.listeningTopic2}" ,groupId = "${kafka.groupId}",
            containerFactory="${kafka.containerFactory}")
    public void consumeEducationJson(@Payload EducationSection educationSection) {
        if(logger.isDebugEnabled()) {
            logger.debug(String.format("${kafka.consumed} : %s", educationSection));
        }
        List<Education> educationList=new ArrayList<>();
        Chicklets[] chicklets=educationSection.getChicklets();
        for(Chicklets chicklet:chicklets){
            Qualification qualification=chicklet.getQualification();
            Institution institution=chicklet.getInstitution();
            String summary=chicklet.getSummary();
            Education education=Education.builder().qualification(qualification)
                    .institution(institution).summary(summary).build();
            educationList.add(education);
        }

        try {
            employeeService.addEducationData(educationList,educationSection.getUserId());
            logger.info("${kafka.success}");

        }catch(EmployeeNotFoundException employeeNotFound){
            logger.error(employeeNotFound.getMessage());
        }catch(Exception exp){
            logger.error(exp.getMessage());
        }

    }


    @KafkaListener(topics = "${kafka.listeningTopic3}" ,groupId = "group_id5",
            containerFactory="userKafkaListenerFactory")

    public void consumeSkillsJson(@Payload SkillsSection skillsSection) {
       if( logger.isDebugEnabled()) {
            logger.debug(String.format("${kafka.consumed} : %s", skillsSection));
        }
        List<Skills> skillsList=new ArrayList<>();
        Chicklets[] chicklets=skillsSection.getChicklets();
        for(Chicklets chicklet:chicklets){

           Skills skill=chicklet.getSkill();

           skillsList.add(skill);
        }

        try {
            employeeService.addSkillsData(skillsList,skillsSection.getUserId());
            logger.info("${kafka.success}");

        }catch(EmployeeNotFoundException employeeNotFound){
            logger.error(employeeNotFound.getMessage());
        }catch(Exception exp){
            logger.error(exp.getMessage());
        }

    }


    @KafkaListener(topics = "${kafka.listeningTopic4}" ,groupId = "group_id5",
            containerFactory="userKafkaListenerFactory")

    public void consumeLocationsJson(@Payload LocationSection locationSection) {
        if( logger.isDebugEnabled()) {
            logger.debug(String.format("${kafka.consumed}: %s", locationSection));
        }
        Location location=Location.builder().build();
        Chicklets[] chicklets=locationSection.getChicklets();
        for(Chicklets chicklet:chicklets){

            CurrentLocation currentLocation=chicklet.getCurrentLocation();
            PastLocation[] pastLocation=chicklet.getPastLocation();
            List<PastLocation> pastLocations= Arrays.asList(pastLocation);
            location.setCurrentLocation(currentLocation);
            location.setPastLocation(pastLocations);
        }

        try {
            employeeService.addLocationData(location,locationSection.getUserId());
            logger.info("${kafka.success}");

        }catch(EmployeeNotFoundException employeeNotFound){
            logger.error(employeeNotFound.getMessage());
        }catch(Exception exp){
            logger.error(exp.getMessage());
        }

    }
}
