package com.stackroute.springbootcertification.listener;

import com.stackroute.springbootcertification.Resource.IndexResource;
import com.stackroute.springbootcertification.domain.CommonOutput;
import com.stackroute.springbootcertification.domain.Relationships;
import com.stackroute.springbootcertification.domain.Section;
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
        //System.out.println("Consumed Json Message: "+ section.toString());
        Relationships relationships[]=new Relationships[1];
        Relationships relationships1=new Relationships("working","is-a");
        relationships[0]=relationships1;
        CommonOutput commonOutput=new CommonOutput("add","SourceNode","SourceNodeProperty",
                "TargetNode","TargetNodeProperty",
                relationships);
        indexResource.postData(commonOutput);
    }
}
