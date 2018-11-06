package com.stackroute.springskill.listener;


import com.stackroute.springskill.domain.Relationship;
import com.stackroute.springskill.domain.CommonOutput;
import com.stackroute.springskill.domain.Section;
import com.stackroute.springskill.resource.IndexResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service

public class KafkaConsumer {

//    @KafkaListener(topics="test", groupId="group_id1")

//    public void consume(String message) {

//        System.out.println("Consumed message: " + message);

//    }
    @Autowired
    IndexResource indexResource;





//    @Autowired
//    public KafkaConsumer(Relationship relationship){
//
//    }

//    @Autowired
    private Relationship relationship1;

    @KafkaListener(topics = "skills", groupId = "group_id13",

            containerFactory = "userKafkaListenerFactory")

    public void consumeJson(@Payload Section section) {



        System.out.println("Consumed Json Message: " + section);

        Relationship relationships[]=new Relationship[1];
        relationship1 = new Relationship("add","has");
        relationships[0]=relationship1;
        CommonOutput commonOutput=new CommonOutput("add","SourceNode","SourceNodeProperty",
                "TargetNode","TargetNodeProperty",relationships);
        indexResource.postData(commonOutput);

    }

}