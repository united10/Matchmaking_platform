package com.stackroute.educationservice.resource;


import com.stackroute.educationservice.domain.KafkaProperties;
import com.stackroute.educationservice.domain.CommonOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class IndexResourceImpl implements IndexResource{
    @Autowired
    private KafkaTemplate<String, CommonOutput> kafkaTemplate;

    private KafkaProperties kafkaProperties;
    @Autowired
    public void setApp(KafkaProperties kafkaProperties){
        this.kafkaProperties=kafkaProperties;
    }

    @Override
    public void postData(CommonOutput commonOutput)
    {
        kafkaTemplate.send(kafkaProperties.getOutputTopic(),commonOutput);
    }

}