package com.stackroute.skillservice.listener;


import com.stackroute.skillservice.domain.Relationship;
import com.stackroute.skillservice.domain.CommonOutput;
import com.stackroute.skillservice.domain.Section;
import com.stackroute.skillservice.resource.IndexResource;
import com.stackroute.skillservice.service.SkillServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private IndexResource indexResource;


    @KafkaListener(topics = "${kafka.linsteningTopic}", groupId ="${kafka.groupId}",

            containerFactory = "${kafka.containerFactory}")

    public void consumeJson(@Payload Section section) {

        CommonOutput commonOutput= new SkillServiceImpl().processSameOutput(section);
        indexResource.postData(commonOutput);

    }

}