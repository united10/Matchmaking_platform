package com.stackroute.indexerservice.service.education;

import com.stackroute.indexerservice.domain.Education;
import com.stackroute.indexerservice.domain.User;
import com.stackroute.indexerservice.domain.input.CommonOutput;
import com.stackroute.indexerservice.domain.input.Property;
import com.stackroute.indexerservice.domain.relationships.EducationRelationshipProperty;
import com.stackroute.indexerservice.repository.EducatedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EducationServiceImpl implements EducationService {
    @Autowired
    private EducatedRepository educatedRepository;
    @Autowired
    private User user;
    @Autowired
    private Education education;

    private Map<String, String> prop;
    private String key;
    private String value;
    private Property[] property;

    public EducationServiceImpl() {
        prop = new HashMap<>();
    }

    public void createNode(CommonOutput commonOutput) {
        user.setUserId(commonOutput.getSourceNode());
        for (int i = 0; i < commonOutput.getTargetNodeProperty().length; i++) {
            education.setName(commonOutput.getTargetNodeProperty()[i].getName());
            EducationRelationshipProperty educationRelationshipProperty = new EducationRelationshipProperty();
            educationRelationshipProperty.setRelationship(commonOutput.getRelationships());
            educationRelationshipProperty.setUser(user);
            educationRelationshipProperty.setEducation(education);
            property = commonOutput.getProperties();
            for (int j = 0; j < property.length; j++) {
                key = property[j].getPropertyName();
                value = property[j].getPropertyValue();
                prop.put(key, value);
            }
            educationRelationshipProperty.setProperties(prop);
            educatedRepository.save(educationRelationshipProperty);
        }
    }

    public void deleteNode(CommonOutput commonOutput) {
        user.setUserId(commonOutput.getSourceNode());
        for (int i = 0; i < commonOutput.getTargetNodeProperty().length; i++) {
            education.setName(commonOutput.getTargetNodeProperty()[i].getName());
            EducationRelationshipProperty educationRelationshipProperty = new EducationRelationshipProperty();
            educationRelationshipProperty.setRelationship(commonOutput.getRelationships());
            educationRelationshipProperty.setUser(user);
            educationRelationshipProperty.setEducation(education);
            property = commonOutput.getProperties();
            for (int j = 0; j < property.length; j++) {
                key = property[j].getPropertyName();
                value = property[j].getPropertyValue();
                prop.put(key, value);
            }
            educationRelationshipProperty.setProperties(prop);
            educatedRepository.deleteById(educationRelationshipProperty.getRelationship());
        }
    }

    public void updateNode(CommonOutput commonOutput){
        user.setUserId(commonOutput.getSourceNode());
        for (int i = 0; i < commonOutput.getTargetNodeProperty().length; i++) {
            education.setName(commonOutput.getTargetNodeProperty()[i].getName());
            EducationRelationshipProperty educationRelationshipProperty = new EducationRelationshipProperty();
            educationRelationshipProperty.setRelationship(commonOutput.getRelationships());
            educationRelationshipProperty.setUser(user);
            educationRelationshipProperty.setEducation(education);
            property = commonOutput.getProperties();
            for (int j = 0; j < property.length; j++) {
                key = property[j].getPropertyName();
                value = property[j].getPropertyValue();
                prop.put(key, value);
            }
            educationRelationshipProperty.setProperties(prop);
            educatedRepository.save(educationRelationshipProperty);
        }
    }
}

