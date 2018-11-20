package com.stackroute.projectservice.listener;

import com.stackroute.projectservice.domain.KafkaProperties;
import com.stackroute.projectservice.domain.CommonOutput;
import com.stackroute.projectservice.domain.Section;
import com.stackroute.projectservice.resource.IndexResource;
import com.stackroute.projectservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class KafkaListen {

    ProjectService projectService;
    IndexResource indexResource;
    KafkaProperties kafkaProperties;

    @Autowired
    public KafkaListen(KafkaProperties kafkaProperties, ProjectService projectService,IndexResource indexResource){
        this.kafkaProperties = kafkaProperties;
        this.indexResource=indexResource;
        this.projectService=projectService;
    }

    @KafkaListener(topics = "${kafka.listeningTopic}" ,groupId = "${kafka.groupId}",
            containerFactory="${kafka.containerFactory}")
    public void consumeJson(@Payload Section section) {
        CommonOutput commonOutput = projectService.processProjectDetails(section);
        indexResource.postData(commonOutput);
    }
}
