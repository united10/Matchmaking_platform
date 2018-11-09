package com.stackroute.educationservice.springlocation.listener;

import com.stackroute.educationservice.springlocation.Resource.IndexResource;
import com.stackroute.educationservice.springlocation.domain.CommonOutput;
import com.stackroute.educationservice.springlocation.domain.Relationship;
import com.stackroute.educationservice.springlocation.domain.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class KafkaListen {

    @Autowired
    IndexResource indexResource;
    @KafkaListener(topics = "location" ,groupId = "group_id11",
            containerFactory="userKafkaListenerFactory")


    public void consumeJson(@Payload Section section) {
        System.out.println("Consumed Json Message: " + section.toString());
        Relationship relationship[] = new Relationship[1];
        Relationship relationship1 = new Relationship("live","lives in");
        relationship[0] = relationship1;
        CommonOutput commonOutput=new CommonOutput("add","SourceNode","SourceNodeProperty",
                "TargetNode","TargetNodeProperty",relationship);
        indexResource.postData(commonOutput);
    }
}
