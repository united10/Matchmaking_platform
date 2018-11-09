package com.stackroute.educationservice.springbootcertification.listener;

import com.stackroute.educationservice.springbootcertification.domain.CommonOutput;
import com.stackroute.educationservice.springbootcertification.domain.Section;
import com.stackroute.educationservice.springbootcertification.resource.IndexResource;
import com.stackroute.educationservice.springbootcertification.domain.Relationships;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaListen {
    @Autowired
    IndexResource indexResource;

    @KafkaListener(topics = "certificate" ,groupId = "group_id3",
            containerFactory="userKafkaListenerFactory")
    public void consumeJson(@Payload Section section) {
        Relationships[] relationships=new Relationships[1];
        Relationships relationships1=new Relationships("working","is-a");
        relationships[0]=relationships1;
        CommonOutput commonOutput=new CommonOutput("add","SourceNode","SourceNodeProperty",
                "TargetNode","TargetNodeProperty",
                relationships);
        indexResource.postData(commonOutput);
    }
}
