package com.stackroute.educationservice.service;

import com.stackroute.educationservice.domain.*;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService {

    @Override
    public CommonOutput processEducationDetails(Section section) {

        System.out.println("Education"+section.toString());

        Chicklets[] chicklets=section.getChicklets();
        Relationships relationship[]=new Relationships[chicklets.length];
        for (int i=0;i<chicklets.length;i++){
            relationship[i]=relationship[i].builder()
                    .relationshipProperty(chicklets[i].getInstitution().getInstitutionName())
                    .relationshipType("studiedIn")
                    .build();

        }
        CommonOutput commonOutput=CommonOutput.builder()
                                    .operationType(section.getOperationType())
                                    .sourceNode(section.getUserId())
                                    .sourceNodeProperties("property 1")
                                    .terminalNode("education")
                                    .terminalNodeProperties("terminal property")
                                    .relationships(relationship)
                                    .build();
        System.out.println(commonOutput.toString());
        return commonOutput;
    }
}
