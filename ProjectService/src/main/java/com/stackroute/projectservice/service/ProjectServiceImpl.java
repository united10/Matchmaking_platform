package com.stackroute.projectservice.service;


import com.stackroute.projectservice.domain.CommonOutput;
import com.stackroute.projectservice.domain.Section;
import com.stackroute.projectservice.domain.Skill;
import com.stackroute.projectservice.domain.Relationship;
import org.springframework.stereotype.Service;

/*This class is a service class and is used
to create the common output that will be send
to 'indexer' kafka topic. In this class we filter
the content from the front end and create a
object for indexing data to the graphdb (neo4j)*/
@Service
public class ProjectServiceImpl implements ProjectService {

    @Override
    public CommonOutput processProjectDetails(Section section){

        Skill[] skills = section.getChicklets()[0].getProjectDetails().getTechnologiesUsed();
        Relationship[] relationship = new Relationship[skills.length];
        for(int i = 0 ; i<skills.length ;i++){
            relationship[i] = Relationship.builder()
                    .relationshipProperty(skills[i].getSkill()).relationshipType("knows").build();
        }

        CommonOutput commonOutput = CommonOutput.builder()
                .operationType(section.getOperationType())
                .sourceNode(section.getUserId())
                .sourceNodeProperty("property1")
                .targetNode("project")
                .targetNodeProperty("target property")
                .relationship(relationship)
                .build();
        return commonOutput;
    }

}
