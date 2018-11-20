package com.stackroute.skillservice.service;

import com.stackroute.skillservice.domain.Chicklet;
import com.stackroute.skillservice.domain.Relationship;
import com.stackroute.skillservice.domain.CommonOutput;
import com.stackroute.skillservice.domain.Section;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {

    Logger logger= LoggerFactory.getLogger(SkillService.class);

    @Override
    public CommonOutput processSameOutput(Section section) {

        logger.info("skills "+section.toString());
        Chicklet[] chicklets=section.getChicklets();
        Relationship[] relationship =new Relationship[chicklets.length];
        for (int i = 0; i< chicklets.length; i++){
            relationship[i]= Relationship.builder().relationshipProperty(chicklets[i].getSkill().getSkillName())
                    .relationshipType("has").build();
        }

        //dummy data
        return CommonOutput.builder()
                .operationType(section.getOperationType())
                .sourceNode(section.getUserId())
                .sourceNodeProperties("gd")
                .terminalNode("skill")
                .terminalNodeProperties("prop")
                .relationship(relationship).build();

    }
}
