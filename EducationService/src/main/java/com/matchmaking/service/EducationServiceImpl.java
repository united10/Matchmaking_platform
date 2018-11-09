package com.matchmaking.service;

import com.matchmaking.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService {

    Logger logger= LoggerFactory.getLogger(EducationServiceImpl.class);
    @Override
    public CommonOutput processEducationDetails(Section section) {

        logger.info(section.toString());

        Chicklets[] chicklets=section.getChicklets();
        Relationship[] relationship=new Relationship[chicklets.length];
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
       logger.info(section.toString());
        return commonOutput;
    }
}
