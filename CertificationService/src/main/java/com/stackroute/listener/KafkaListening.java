package com.stackroute.listener;

import com.stackroute.resource.IndexResource;
import com.stackroute.domain.CommonOutput;
import com.stackroute.domain.Relationships;
import com.stackroute.domain.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaListening {
    @Autowired
    IndexResource indexResource;

    @KafkaListener(topics = "${kafka.listeningTopic}" ,groupId = "${kafka.groupId}",
            containerFactory="${kafka.containerFactory}")
    public void consumeJson(@Payload Section section) {
        System.out.print("Consumed Message "+ section);
        Relationships[] relationships=new Relationships[1];
        Relationships relationships1=new Relationships("working","is-a");
        relationships[0]=relationships1;
        CommonOutput commonOutput=new CommonOutput("add","SourceNode","SourceNodeProperty",
                "TargetNode","TargetNodeProperty",
                relationships);
        indexResource.postData(commonOutput);
    }
}
