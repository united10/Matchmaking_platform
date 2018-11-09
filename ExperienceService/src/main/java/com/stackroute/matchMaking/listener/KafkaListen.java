package com.stackroute.matchMaking.listener;

import com.stackroute.matchMaking.domain.CommonOutput;
import com.stackroute.matchMaking.domain.Experience;
import com.stackroute.matchMaking.domain.Relationships;
import com.stackroute.matchMaking.domain.Section;
import com.stackroute.matchMaking.resource.IndexResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class KafkaListen {
    @Autowired
    IndexResource indexResource;

    @KafkaListener(topics="experience",groupId = "group_exp",containerFactory = "userKafkaListenerFactory")
    public void consumeJson(@Payload Section exp)
    {
        System.out.println("Consumed Message" + exp.toString());
        Relationships relationships=new Relationships("Working","is-a");
        CommonOutput commonOutput=new CommonOutput("post","vivek","pandit",
                "ram","mandir",relationships);
        indexResource.postDate(commonOutput);
    }
}
