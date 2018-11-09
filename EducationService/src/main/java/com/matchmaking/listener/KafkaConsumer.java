package com.matchmaking.listener;

import com.matchmaking.domain.CommonOutput;
import com.matchmaking.domain.Section;
import com.matchmaking.resource.IndexResource;
import com.matchmaking.service.EducationService;
import com.oracle.tools.packager.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    Logger logger= LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    EducationService educationService;
    @Autowired
    IndexResource indexResource;
    @KafkaListener(topics = "education" ,groupId = "group_id12",
            containerFactory="userKafkaListenerFactory")
    public void consumeJson(@Payload Section section ) {
        Log.info("consumed json message "+section);
        logger.debug(Marker.ANY_MARKER,section);
        CommonOutput commonOutput= educationService.processEducationDetails(section);
        indexResource.postData(commonOutput);
    }
}