package com.stackroute.listener;

import com.stackroute.resource.IndexResourceImplementation;
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
    IndexResourceImplementation indexResourceImplementation;

    @KafkaListener(topics = "certificate" ,groupId = "group_id3",
            containerFactory="userKafkaListenerFactory")
    public void consumeJson(@Payload Section section) {
        Relationships[] relationships=new Relationships[1];
        Relationships relationships1=new Relationships("working","is-a");
        relationships[0]=relationships1;
        CommonOutput commonOutput=new CommonOutput("add","SourceNode","SourceNodeProperty",
                "TargetNode","TargetNodeProperty",
                relationships);
        indexResourceImplementation.postData(commonOutput);
    }
}
