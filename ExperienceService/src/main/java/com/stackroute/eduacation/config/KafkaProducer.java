package com.stackroute.matchmaking.config;

import com.stackroute.matchmaking.domain.CommonOutput;
import com.stackroute.matchmaking.domain.KafkaProperties;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class KafkaProducer {


    private KafkaProperties kafkaProperties;

    @Autowired
    public void setApp(KafkaProperties kafkaProperties){
        this.kafkaProperties=kafkaProperties;
    }

    @Bean
    public ProducerFactory<String, CommonOutput> producerFactory() {

        Map<String, Object> config =new HashMap<>();
<<<<<<< HEAD:EducationService/src/main/java/com/stackroute/educationservice/config/KafkaProducer.java
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getIpAddress());
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS,false);
=======

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaProperties.getIpAddress());
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


>>>>>>> abbc4b9affc0ca2ee5dada13c0ee498c42a34928:ExperienceService/src/main/java/com/stackroute/matchmaking/config/KafkaProducer.java
        return new DefaultKafkaProducerFactory(config);

    }

    @Bean
    public KafkaTemplate<String, CommonOutput> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
