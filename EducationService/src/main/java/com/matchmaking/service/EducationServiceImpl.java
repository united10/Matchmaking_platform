package com.matchmaking.service;

import com.matchmaking.domain.*;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService {

    @Override
    public CommonOutput processEducationDetails(Section section) {

        System.out.println("Education"+section.toString());

        Chicklets chicklets[]=section.getChicklets();
        Relationship relationship[]=new Relationship[chicklets.length];
        for (int i=0;i<chicklets.length;i++){
            relationship[i]=relationship[i].builder()
                    .relationshipProperty(chicklets[i].getInstitution().getInstitutionName())
                    .relationshipType("studiedIn")
                    .build();

        }
        CommonOutput commonOutput=CommonOutput.builder()
                                    .operationType(section.getOperationType())
                                    .sourceNode(section.getUserId())
                                    .sourceProperties("property 1")
                                    .terminalNode("education")
                                    .terminalProperties("terminal property")
                                    .relationship(relationship)
                                    .build();
        System.out.println(commonOutput.toString());
        return commonOutput;
    }
}
