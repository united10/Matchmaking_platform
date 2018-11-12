package com.stackroute.educationservice.listener;

import com.stackroute.educationservice.domain.CommonOutput;
import com.stackroute.educationservice.domain.KafkaProperties;
import com.stackroute.educationservice.domain.Section;
import com.stackroute.educationservice.resource.IndexResource;
import com.stackroute.educationservice.service.EducationService;
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


    Logger logger= LoggerFactory.getLogger(KafkaListener.class);
    @Autowired
    EducationService educationService;
    @Autowired
    IndexResource indexResource;
    private KafkaProperties kafkaProperties;

    /*@Autowired
    public void setApp(KafkaProperties kafkaProperties){
        this.kafkaProperties=kafkaProperties;

    }*/
    @KafkaListener(topics = "${kafka.linsteningTopic}" ,groupId = "${kafka.groupId}",
            containerFactory="${kafka.containerFactory}")
    public void consumeJson(@Payload Section section ) {

        Log.info("consumed json message "+section);
        logger.debug(Marker.ANY_MARKER,section);
        CommonOutput commonOutput= educationService.processEducationDetails(section);
        indexResource.postData(commonOutput);
    }
}