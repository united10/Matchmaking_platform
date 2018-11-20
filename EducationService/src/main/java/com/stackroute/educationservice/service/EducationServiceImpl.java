package com.stackroute.educationservice.service;

import com.stackroute.educationservice.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService {

    Logger logger= LoggerFactory.getLogger(EducationServiceImpl.class);
    @Override
    public CommonOutput processEducationDetails(Section section) {

        System.out.println("Education"+section.toString());
        logger.info("education "+section.toString());
        Chicklets[] chicklets=section.getChicklets();
        Relationships relationship[]=new Relationships[chicklets.length];
        for (int i=0;i<chicklets.length;i++){
            relationship[i]=relationship[i].builder()
                    .relationshipProperty(chicklets[i].getInstitution().getInstitutionName())
                    .relationshipType("studiedIn")
                    .build();

        }
        //dummy
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
