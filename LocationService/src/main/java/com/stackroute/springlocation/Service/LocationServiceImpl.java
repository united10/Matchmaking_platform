package com.stackroute.springlocation.Service;


import com.stackroute.springlocation.domain.CommonOutput;
import com.stackroute.springlocation.domain.PastLocation;
import com.stackroute.springlocation.domain.Relationship;
import com.stackroute.springlocation.domain.Section;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService{

    @Override
    public CommonOutput processLocationDetails(Section section){

        PastLocation pastLocation[] = section.getChicklets()[0].getPastLocation();
        Relationship relationship[] = new Relationship[pastLocation.length];
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
