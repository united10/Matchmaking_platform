package com.matchmaking.listener;

import com.matchmaking.domain.CommonOutput;
import com.matchmaking.domain.Section;
import com.matchmaking.resource.IndexResource;
import com.matchmaking.service.EducationService;
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
    EducationService educationService;
    @Autowired
    IndexResource indexResource;
    @KafkaListener(topics = "education" ,groupId = "group_id12",
            containerFactory="userKafkaListenerFactory")
    public void consumeJson(@Payload Section section ) {
        System.out.println("Consumed Json Message: "+ section);
        CommonOutput commonOutput= educationService.processEducationDetails(section);
        indexResource.postData(commonOutput);
    }
}