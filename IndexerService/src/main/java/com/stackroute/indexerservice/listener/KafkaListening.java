package com.stackroute.indexerservice.listener;

import com.stackroute.indexerservice.domain.input.Property;
import com.stackroute.indexerservice.domain.input.CommonOutput;
import com.stackroute.indexerservice.domain.input.TargetProperty;
import com.stackroute.indexerservice.service.OntologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaListening {
    @Autowired
    OntologyService ontologyService;

    private TargetProperty[] targetProperties;

    private Property[] properties;
    @Autowired
    private CommonOutput commonOutputLower;

    @KafkaListener(topics = "${kafka.listeningTopic}" , groupId = "${kafka.groupId}",
                containerFactory="${kafka.containerFactory}")
    public void consumeJson(@Payload CommonOutput commonOutput) {

        CommonOutput indexerData=convertToLowercase(commonOutput);

        if(commonOutput.getOperationType().equals("post"))
        {
            ontologyService.createNode(indexerData);
        }
        else if(commonOutput.getOperationType().equals("delete"))
        {
            ontologyService.deleteNode(indexerData);
        }
        else if(commonOutput.getOperationType().equals("put"))
        {
            ontologyService.updateNode(indexerData);
        }
    }

    public CommonOutput convertToLowercase(CommonOutput commonOutput){
        if(commonOutput.getProperties()==null)
        {
            return commonOutput;
        }
        targetProperties = new TargetProperty[commonOutput.getTargetNodeProperty().length];
        properties = new Property[commonOutput.getProperties().length];
        commonOutputLower.setOperationType(commonOutput.getOperationType().toLowerCase());
        commonOutputLower.setSourceNode(commonOutput.getSourceNode().toLowerCase());
        commonOutputLower.setTargetNode(commonOutput.getTargetNode().toLowerCase());

        for(int i=0;i<commonOutput.getTargetNodeProperty().length;i++)
        {
            TargetProperty targetProperty = TargetProperty.builder().name(commonOutput
                    .getTargetNodeProperty()[i].getName().toLowerCase()).build();
            targetProperties[i]=targetProperty;
        }
        commonOutputLower.setTargetNodeProperty(targetProperties);
        commonOutputLower.setRelationships(commonOutput.getRelationships().toLowerCase());
        for(int i=0;i<commonOutput.getProperties().length;i++)
        {
            Property property=Property.builder().propertyName(commonOutput.getProperties()[i].getPropertyName().toLowerCase())
                    .propertyValue(commonOutput.getProperties()[i].getPropertyValue().toLowerCase())
                    .build();

            properties[i]=property;
        }
        commonOutputLower.setProperties(properties);
        return commonOutputLower;
    }
}