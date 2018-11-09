package com.stackroute.projectservice.Service;


import com.stackroute.projectservice.domain.CommonOutput;
import com.stackroute.projectservice.domain.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Override
    public CommonOutput processProjectDetails(Project project){
        CommonOutput commonOutput = CommonOutput.builder()
                .operationType(project.getOperationType())
                .sourceNode(project.getUserId())
                .sourceNodeProperty("property1")
                .targetNode("location")
                .targetNodeProperty("target property")
                .relationshipType("lives in")
                .relationshipProperty("ssid")
                .build();
        System.out.println(commonOutput.toString());
        return commonOutput;
    }

}
