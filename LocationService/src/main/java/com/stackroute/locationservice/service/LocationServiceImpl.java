package com.stackroute.locationservice.service;


import com.stackroute.locationservice.domain.CommonOutput;
import com.stackroute.locationservice.domain.PastLocation;
import com.stackroute.locationservice.domain.Relationship;
import com.stackroute.locationservice.domain.Section;
import org.springframework.stereotype.Service;


/* This service is used to create the common output that will be send
to 'indexer' kafka topic. Here we process
the data from front end and create an
object for indexing data to the graphdb (neo4j)*/
@Service
public class LocationServiceImpl implements LocationService{

    @Override
    public CommonOutput processLocationDetails(Section section){

        PastLocation[] pastLocation = section.getChicklets()[0].getPastLocation();
        Relationship[] relationship = new Relationship[pastLocation.length];
        for(int i = 0 ; i<pastLocation.length ;i++){
            relationship[i] = Relationship.builder()
                    .relationshipProperty(pastLocation[i].getCityName()).relationshipType("lives in").build();
        }


        CommonOutput commonOutput = CommonOutput.builder()
                .operationType(section.getOperationType())
                .sourceNode(section.getUserId())
                .sourceNodeProperty("property1")
                .targetNode("location")
                .targetNodeProperty("target property")
                .relationship(relationship)
                .build();
        System.out.println(commonOutput.toString());
        return commonOutput;
    }

}
