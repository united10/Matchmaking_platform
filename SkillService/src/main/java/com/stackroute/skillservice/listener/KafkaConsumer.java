package com.stackroute.skillservice.listener;


import com.stackroute.skillservice.domain.Relationship;
import com.stackroute.skillservice.domain.CommonOutput;
import com.stackroute.skillservice.domain.Section;
import com.stackroute.skillservice.resource.IndexResource;
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



        Relationship relationship1;
        Relationship[] relationships=new Relationship[1];
        relationship1 = new Relationship("add","has");
        relationships[0]=relationship1;
        CommonOutput commonOutput=new CommonOutput("add","SourceNode","SourceNodeProperty",
                "TargetNode","TargetNodeProperty",relationships);
        indexResource.postData(commonOutput);

    }

}