package com.stackroute.projectservice.resource;

import com.stackroute.projectservice.domain.CommonOutput;
import com.stackroute.projectservice.domain.KafkaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class IndexResourceImpl implements IndexResource {

    private KafkaTemplate<String , CommonOutput> kafkaTemplate;
    private KafkaProperties kafkaProperties;

    @Autowired
    public IndexResourceImpl(KafkaProperties kafkaProperties, KafkaTemplate kafkaTemplate){
        this.kafkaProperties = kafkaProperties;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void postData(CommonOutput commonOutput){
        kafkaTemplate.send(kafkaProperties.getOutputTopic(), commonOutput);
    }
}
