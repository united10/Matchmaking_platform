package com.stackroute.educationservice.matchMaking.resource;

import com.stackroute.educationservice.matchMaking.domain.CommonOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class IndexResource {
    @Autowired
    private KafkaTemplate<String, CommonOutput> kafkaTemplate;
    private static final String TOPIC="indexer";

    public void postDate(CommonOutput commonOutput)
    {
        kafkaTemplate.send(TOPIC,commonOutput);
    }
}
