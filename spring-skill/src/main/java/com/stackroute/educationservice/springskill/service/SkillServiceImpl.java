package com.stackroute.educationservice.springskill.service;

import com.stackroute.educationservice.springskill.domain.Chicklet;
import com.stackroute.educationservice.springskill.domain.Relationship;
import com.stackroute.educationservice.springskill.domain.CommonOutput;
import com.stackroute.educationservice.springskill.domain.Section;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {


    @Override
    public CommonOutput processSameOutput(Section section) {

        Chicklet chicklets[]=section.getChicklets();
        Relationship relationship[] =new Relationship[chicklets.length];
        for (int i = 0; i< chicklets.length; i++){
            relationship[i]= Relationship.builder().relationshipProperty(chicklets[i].getSkill().getSkillName())
                    .relationshipType("has").build();
        }
        CommonOutput commonOutput = CommonOutput.builder()
                .operationType(section.getOperationType())
                .sourceNode(section.getUserId())
                .SourceNodeProperties("gd")
                .terminalNode("skill")
                .terminalNodeProperties("prop")
                .relationship(relationship).build();
        System.out.println(commonOutput.toString());
        return commonOutput;
    }
}
