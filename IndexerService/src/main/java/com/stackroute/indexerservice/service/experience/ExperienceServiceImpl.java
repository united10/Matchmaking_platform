package com.stackroute.indexerservice.service.experience;

import com.stackroute.indexerservice.domain.Organization;
import com.stackroute.indexerservice.domain.User;
import com.stackroute.indexerservice.domain.input.CommonOutput;
import com.stackroute.indexerservice.domain.input.Property;
import com.stackroute.indexerservice.domain.relationships.ExperienceRelationshipProperty;
import com.stackroute.indexerservice.repository.WorksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExperienceServiceImpl  implements  ExperienceService{
    @Autowired
    private WorksRepository worksRepository;
    @Autowired
    private User user;
    @Autowired
    private Organization organization;
    private Map<String,String> prop;
    private String key;
    private String value;
    private Property[] property;
    public ExperienceServiceImpl(){

        prop = new HashMap<>();

    }

    public void createNode(CommonOutput commonOutput) {
        user.setUserId(commonOutput.getSourceNode());
        for (int i = 0; i < commonOutput.getTargetNodeProperty().length; i++)
        {
            organization.setName(commonOutput.getTargetNodeProperty()[i].getName());
            ExperienceRelationshipProperty experienceRelationshipProperty = new ExperienceRelationshipProperty();
            experienceRelationshipProperty.setRelationship(commonOutput.getRelationships());
            experienceRelationshipProperty.setUser(user);
            experienceRelationshipProperty.setOrganization(organization);
            property = commonOutput.getProperties();
            for (int j = 0; j < property.length; j++) {
                key = property[j].getPropertyName();
                value = property[j].getPropertyValue();
                prop.put(key, value);
            }
            experienceRelationshipProperty.setProperties(prop);
            worksRepository.save(experienceRelationshipProperty);
        }
    }
    public void deleteNode(CommonOutput commonOutput){
        user.setUserId(commonOutput.getSourceNode());
        for (int i = 0; i < commonOutput.getTargetNodeProperty().length; i++) {
            organization.setName(commonOutput.getTargetNodeProperty()[i].getName());
            ExperienceRelationshipProperty experienceRelationshipProperty = new ExperienceRelationshipProperty();
            experienceRelationshipProperty.setRelationship(commonOutput.getRelationships());
            experienceRelationshipProperty.setUser(user);
            experienceRelationshipProperty.setOrganization(organization);
            property = commonOutput.getProperties();
            for (int j = 0; j < property.length; j++) {
                key = property[j].getPropertyName();
                value = property[j].getPropertyValue();
                prop.put(key, value);
            }
            experienceRelationshipProperty.setProperties(prop);
            worksRepository.deleteById(experienceRelationshipProperty.getRelationship());
        }
    }

    public  void updateNode(CommonOutput commonOutput){
        user.setUserId(commonOutput.getSourceNode());
        for (int i = 0; i < commonOutput.getTargetNodeProperty().length; i++)
        {
            organization.setName(commonOutput.getTargetNodeProperty()[i].getName());
            ExperienceRelationshipProperty experienceRelationshipProperty = new ExperienceRelationshipProperty();
            experienceRelationshipProperty.setRelationship(commonOutput.getRelationships());
            experienceRelationshipProperty.setUser(user);
            experienceRelationshipProperty.setOrganization(organization);
            property = commonOutput.getProperties();
            for (int j = 0; j < property.length; j++) {
                key = property[j].getPropertyName();
                value = property[j].getPropertyValue();
                prop.put(key, value);
            }
            experienceRelationshipProperty.setProperties(prop);
            worksRepository.save(experienceRelationshipProperty);
        }
    }
}
