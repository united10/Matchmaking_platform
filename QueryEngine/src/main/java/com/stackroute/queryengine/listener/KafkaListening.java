package com.stackroute.queryengine.listener;

import com.stackroute.queryengine.domain.Output;
import com.stackroute.queryengine.service.DriverInit;
import com.stackroute.queryengine.service.QueryService;
import org.neo4j.driver.v1.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaListening {

    Logger logger = LoggerFactory.getLogger(KafkaListening.class);

    private DriverInit driver = new DriverInit("bolt://0.0.0.0","neo4j","123456");


    @Autowired
    QueryService queryService;

    @KafkaListener(topics = "${kafka.listeningTopic}", groupId = "${kafka.groupId}",
            containerFactory = "${kafka.containerFactory}")

    public void consumeJson(@Payload Output output) {
        logger.info("kafka listend output: {}", output);
        Driver drive = driver.getDriver();
        queryService.runquery(drive,output);
    }
}
