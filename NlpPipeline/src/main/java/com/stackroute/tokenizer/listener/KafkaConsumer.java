package com.stackroute.tokenizer.listener;

//Method for listening to user topic and saving

import com.stackroute.tokenizer.domain.Output;
import com.stackroute.tokenizer.domain.Search;
import com.stackroute.tokenizer.producer.DataSender;
import com.stackroute.tokenizer.service.ProcessQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaConsumer {

    @Autowired
    DataSender dataSender;
    @KafkaListener(topics = "${kafka.listeningTopic}", groupId = "${kafka.groupId}",
            containerFactory = "${kafka.containerFactory}")
    public void consumeJson(@Payload Search search) {

        System.out.println("Consumed json:"+ search);

        String searchString=search.getQuery();
        ProcessQuery query=new ProcessQuery();
        Output output=query.tokenizeQuery(searchString);
        System.out.println("udit "+output);
        dataSender.postData(output);
    }



}