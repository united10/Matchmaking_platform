package com.stackroute.DownstreamService.listener;


import com.stackroute.DownstreamService.domain.*;
import com.stackroute.DownstreamService.exceptions.EmployeeAlreadyExistsException;
import com.stackroute.DownstreamService.exceptions.EmployeeNotFoundException;
import com.stackroute.DownstreamService.repository.EmployeeRepository;
import com.stackroute.DownstreamService.service.EmployeeService;
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

    @Autowired
    public KafkaConsumer(EmployeeService employeeService) {

        this.employeeService=employeeService;
    }

//    @KafkaListener(topics = "user" ,groupId = "group_id5",
//    containerFactory="userKafkaListenerFactory")
//    public void consumeJson(@Payload Employee employee) {
//        Employee employee1=Employee.builder().userId(employee.getEmail())
//                .email(employee.getEmail()).name(employee.getName())
//                .build();
//        System.out.println("Consumed: "+employee1);
//
//        try {
//            employeeService.saveEmployee(employee1);
//        }catch (EmployeeAlreadyExistsException exception){
//            System.out.println(exception.getMessage());
//        }catch(Exception exp){
//            System.out.println(exp.getMessage());
//        }
//    }

    @KafkaListener(topics = "education" ,groupId = "group_id5",
            containerFactory="userKafkaListenerFactory")
    public void consumeEducationJson(@Payload EducationSection educationSection) {

        System.out.println("Consumed :" + educationSection);
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
            System.out.println(employeeNotFound.getMessage());
        }





    }


    @KafkaListener(topics = "skills" ,groupId = "group_id5",
            containerFactory="userKafkaListenerFactory")

    public void consumeSkillsJson(@Payload SkillsSection skillsSection) {

        System.out.println("Consumed :" + skillsSection);
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
