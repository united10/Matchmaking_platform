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
import java.util.List;

@Service
public class KafkaConsumer {

//    @KafkaListener(topics="test", groupId="group_id1")
//    public void consume(String message) {
//        System.out.println("Consumed message: " + message);
//    }

    private EmployeeService employeeService;
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    public KafkaConsumer(EmployeeService employeeService) {

        this.employeeService=employeeService;
    }

    @KafkaListener(topics = "user" ,groupId = "group_id5",
    containerFactory="userKafkaListenerFactory")
    public void consumeJson(@Payload Employee employee) {
        Employee employee1=Employee.builder().userId(employee.getEmail())
                .email(employee.getEmail()).name(employee.getName())
                .build();
        if(logger.isDebugEnabled()) {
            logger.debug(String.format("Consumed: %s", employee1));
        }
        try {
            employeeService.saveEmployee(employee1);
        }catch (EmployeeAlreadyExistsException exception){
            logger.error(exception.getMessage());
        }catch(Exception exp){
            logger.error(exp.getMessage());
        }
    }

    @KafkaListener(topics = "education" ,groupId = "group_id5",
            containerFactory="userKafkaListenerFactory")
    public void consumeEducationJson(@Payload EducationSection educationSection) {
        if(logger.isDebugEnabled()) {
            logger.debug(String.format("Consumed : %s", educationSection));
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

        }catch(EmployeeNotFoundException employeeNotFound){
            logger.error(employeeNotFound.getMessage());
        }





    }


    @KafkaListener(topics = "skills" ,groupId = "group_id5",
            containerFactory="userKafkaListenerFactory")

    public void consumeSkillsJson(@Payload SkillsSection skillsSection) {
       if( logger.isDebugEnabled()) {
            logger.debug(String.format("Consumed : %s", skillsSection));
        }
//        List<Education> educationList=new ArrayList<>();
//        Chicklets[] chicklets=skillsSection.getChicklets();
//        for(Chicklets chicklet:chicklets){
//            Qualification qualification=chicklet.getQualification();
//            Institution institution=chicklet.getInstitution();
//            String summary=chicklet.getSummary();
//            Education education=Education.builder().qualification(qualification)
//                    .institution(institution).summary(summary).build();
//            educationList.add(education);
//        }
//
//        try {
//            employeeService.addEducationData(educationList,skillsSection.getUserId());
//
//        }catch(EmployeeNotFoundException employeeNotFound){
//            System.out.println(employeeNotFound.getMessage());
//        }





    }
}
