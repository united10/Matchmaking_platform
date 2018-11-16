package com.stackroute.experienceservice.listener;

import com.stackroute.experienceservice.domain.CommonOutput;
import com.stackroute.experienceservice.domain.Relationships;
import com.stackroute.experienceservice.domain.Section;
import com.stackroute.experienceservice.resource.IndexResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class KafkaListen {
    @Autowired
    IndexResource indexResource;


    @KafkaListener(topics="${kafka.linsteningTopic}",groupId = "${kafka.groupId}",containerFactory = "${kafka.containerFactory}")
    public void consumeJson(@Payload Section exp)
    {
        System.out.println( exp);
        Relationships relationships=new Relationships("Working","is-a");
        CommonOutput commonOutput=new CommonOutput("post","vivek","pandey",
                "Bangalore","Visiting",relationships);
        indexResource.postDate(commonOutput);
    }
}