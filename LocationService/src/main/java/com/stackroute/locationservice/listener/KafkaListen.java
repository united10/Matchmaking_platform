package com.stackroute.locationservice.listener;

import com.stackroute.locationservice.domain.KafkaProperties;
import com.stackroute.locationservice.domain.CommonOutput;
import com.stackroute.locationservice.domain.Section;
import com.stackroute.locationservice.resource.IndexResource;
import com.stackroute.locationservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class KafkaListen {

    @Autowired
    LocationService locationService;

    @Autowired
    IndexResource indexResource;

    @Autowired
    private KafkaProperties kafkaProperties;
    public void setApp(KafkaProperties kafkaProperties){
        this.kafkaProperties = kafkaProperties;
    }

    @KafkaListener(topics = "${kafka.listeningTopic}" ,groupId = "${kafka.groupId}",
            containerFactory="${kafka.containerFactory}")


    public void consumeJson(@Payload Section section) {

//        Relationship[] relationship = new Relationship[1];
//        Relationship relationship1 = new Relationship("live","lives in");
//        relationship[0] = relationship1;
//        CommonOutput commonOutput=new CommonOutput("add","SourceNode","SourceNodeProperty",
//                "TargetNode","TargetNodeProperty",relationship);

        CommonOutput commonOutput = locationService.processLocationDetails(section);

        indexResource.postData(commonOutput);
    }
}
