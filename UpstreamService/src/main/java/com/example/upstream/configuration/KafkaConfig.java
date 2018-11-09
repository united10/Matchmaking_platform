package com.example.upstream.configuration;

import com.example.upstream.domain.certificate.Certificate;
import com.example.upstream.domain.education.Education;
import com.example.upstream.domain.experience.Experience;
import com.example.upstream.domain.location.Location;
import com.example.upstream.domain.project.Project;
import com.example.upstream.domain.skills.Section;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ProducerFactory<String, Education> producerFactoryEducation() {

        Map<String, Object> config =new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.23.239.245:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


        return new DefaultKafkaProducerFactory(config);

    }
    @Bean
    public ProducerFactory<String, Location> producerFactoryLocation() {

        Map<String, Object> config =new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.23.239.245:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


        return new DefaultKafkaProducerFactory(config);

    }
    @Bean
    public ProducerFactory<String, Experience> producerFactoryExperience() {

        Map<String, Object> config =new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.23.239.245:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


        return new DefaultKafkaProducerFactory(config);

    }
    @Bean
    public ProducerFactory<String, Section> producerFactorySkill() {

        Map<String, Object> config =new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.23.239.245:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


        return new DefaultKafkaProducerFactory(config);

    }
    @Bean
    public ProducerFactory<String, Project> producerFactoryProject() {

        Map<String, Object> config =new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.23.239.245:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


        return new DefaultKafkaProducerFactory(config);

    }
    @Bean
    public ProducerFactory<String, Certificate> producerFactoryCertificate() {

        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "172.23.239.245:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);


        return new DefaultKafkaProducerFactory(config);
    }
        //Creating templates for each objects
    @Bean
    public KafkaTemplate<String, Education> kafkaTemplateEducation()
    {
        return new KafkaTemplate<>(producerFactoryEducation());
    }
    @Bean
    public KafkaTemplate<String, Location> kafkaTemplateLocation()
    {
        return new KafkaTemplate<>(producerFactoryLocation());
    }
    @Bean
    public KafkaTemplate<String, Experience> kafkaTemplateExperience()
    {
        return new KafkaTemplate<>(producerFactoryExperience());
    }
    @Bean
    public KafkaTemplate<String, Section> kafkaTemplateSkills()
    {
        return new KafkaTemplate<>(producerFactorySkill());
    }
    @Bean
    public KafkaTemplate<String, Project> kafkaTemplateProject()
    {
        return new KafkaTemplate<>(producerFactoryProject());
    }
    @Bean
    public KafkaTemplate<String, Certificate> kafkaTemplateCertificate()
    {
        return new KafkaTemplate<>(producerFactoryCertificate());
    }
}
