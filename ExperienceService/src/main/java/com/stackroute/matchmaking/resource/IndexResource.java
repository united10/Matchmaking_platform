package com.stackroute.matchmaking.resource;

import com.stackroute.matchmaking.domain.CommonOutput;
import com.stackroute.matchmaking.domain.KafkaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class IndexResource {
    @Autowired
    private KafkaTemplate<String, CommonOutput> kafkaTemplate;


    private KafkaProperties kafkaProperties;

    @Autowired
    public void setApp(KafkaProperties kafkaProperties){
        this.kafkaProperties=kafkaProperties;
    }


    public void postDate(CommonOutput commonOutput)
    {
        kafkaTemplate.send(kafkaProperties.getOutputTopic(),commonOutput);
    }
}
