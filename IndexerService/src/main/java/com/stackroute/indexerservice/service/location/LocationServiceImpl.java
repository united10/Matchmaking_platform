package com.stackroute.indexerservice.service.location;


import com.stackroute.indexerservice.domain.Location;
import com.stackroute.indexerservice.domain.User;
import com.stackroute.indexerservice.domain.input.CommonOutput;
import com.stackroute.indexerservice.domain.input.Property;
import com.stackroute.indexerservice.domain.relationships.LocationRelationshipProperty;
import com.stackroute.indexerservice.repository.LivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LivesRepository livesRepository;
    @Autowired
    private User user;
    @Autowired
    private Location location;
    private Map<String,String> prop;
    private String key;
    private String value;
    private Property[] property;

    public LocationServiceImpl(){
        prop = new HashMap<>();
    }

    public void createNode(CommonOutput commonOutput) {
        user.setUserId(commonOutput.getSourceNode());
        for (int i = 0; i < commonOutput.getTargetNodeProperty().length; i++) {
            location.setName(commonOutput.getTargetNodeProperty()[i].getName());
            LocationRelationshipProperty locationRelationshipProperty = new LocationRelationshipProperty();
            locationRelationshipProperty.setRelationship(commonOutput.getRelationships());
            locationRelationshipProperty.setUser(user);
            locationRelationshipProperty.setLocation(location);
            livesRepository.save(locationRelationshipProperty);
        }
    }

    public void deleteNode(CommonOutput commonOutput) {
        user.setUserId(commonOutput.getSourceNode());
        for (int i = 0; i < commonOutput.getTargetNodeProperty().length; i++) {
            location.setName(commonOutput.getTargetNodeProperty()[i].getName());
            LocationRelationshipProperty locationRelationshipProperty = new LocationRelationshipProperty();
            locationRelationshipProperty.setRelationship(commonOutput.getRelationships());
            locationRelationshipProperty.setUser(user);
            locationRelationshipProperty.setLocation(location);
            livesRepository.deleteById(locationRelationshipProperty.getRelationship());
        }
    }

    public void updateNode(CommonOutput commonOutput){
        user.setUserId(commonOutput.getSourceNode());
        for (int i = 0; i < commonOutput.getTargetNodeProperty().length; i++) {
            location.setName(commonOutput.getTargetNodeProperty()[i].getName());
            LocationRelationshipProperty locationRelationshipProperty = new LocationRelationshipProperty();
            locationRelationshipProperty.setRelationship(commonOutput.getRelationships());
            locationRelationshipProperty.setUser(user);
            locationRelationshipProperty.setLocation(location);
            livesRepository.save(locationRelationshipProperty);
            }
        }
}
