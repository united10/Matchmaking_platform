package com.stackroute.service;

import com.stackroute.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/*This service is used
to create the common output that will be send
to indexer kafka topic in this class we filter
the content from the front end and create a
object for indexing data to the graphdb*/
@Service
public class CertificateServiceImpl implements CertificateService{
    Logger logger= LoggerFactory.getLogger(CertificateServiceImpl.class);
    @Override
    public CommonOutput processCertificateDetails(Section section) {
        logger.info("certificate"+section.toString());
        Chicklets[] chicklets=section.getChicklets();
        Relationships relationship[]=new Relationships[chicklets.length];
        for (int i=0;i<chicklets.length;i++){
            relationship[i]=relationship[i].builder()
                    .relationshipProperty(chicklets[i].getCertificateDetails().getCertificateName())
                    .relationshipType("studiedIn")
                    .build();
        }
        CommonOutput commonOutput=CommonOutput.builder()
                .operationType(section.getOperationType())
                .sourceNode(section.getUserId())
                .sourceNodeProperty("property 1")
                .targetNode("education")
                .targetNodeProperty("terminal property")
                .relationships(relationship)
                .build();
        return commonOutput;
    }
}
