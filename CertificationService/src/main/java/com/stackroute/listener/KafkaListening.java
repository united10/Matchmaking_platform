package com.stackroute.listener;

import com.stackroute.resource.IndexResource;
import com.stackroute.domain.CommonOutput;
import com.stackroute.domain.Relationships;
import com.stackroute.domain.Section;
import com.stackroute.service.CertificateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaListening {
    Logger logger= LoggerFactory.getLogger(KafkaListening.class);
    @Autowired
    IndexResource indexResource;

    @Autowired
    CertificateService certificateService;

    @KafkaListener(topics = "${kafka.listeningTopic}" ,groupId = "${kafka.groupId}",
            containerFactory="${kafka.containerFactory}")

    public void consumeJson(@Payload Section section) {
        logger.debug(Marker.ANY_MARKER,section);
        CommonOutput commonOutput=certificateService.processCertificateDetails(section);
        indexResource.postData(commonOutput);
    }
}
