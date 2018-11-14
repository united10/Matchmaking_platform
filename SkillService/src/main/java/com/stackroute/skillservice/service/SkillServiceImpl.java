package com.stackroute.skillservice.service;

import com.stackroute.skillservice.domain.Chicklet;
import com.stackroute.skillservice.domain.Relationship;
import com.stackroute.skillservice.domain.CommonOutput;
import com.stackroute.skillservice.domain.Section;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {


    @Override
    public CommonOutput processSameOutput(Section section) {

        Chicklet[] chicklets=section.getChicklets();
        Relationship[] relationship =new Relationship[chicklets.length];
        for (int i = 0; i< chicklets.length; i++){
            relationship[i]= Relationship.builder().relationshipProperty(chicklets[i].getSkill().getSkillName())
                    .relationshipType("has").build();
        }
        return CommonOutput.builder()
                .operationType(section.getOperationType())
                .sourceNode(section.getUserId())
                .sourceNodeProperties("gd")
                .terminalNode("skill")
                .terminalNodeProperties("prop")
                .relationship(relationship).build();

    }
}
