package com.stackroute.indexerservice.service.certification;


import com.stackroute.indexerservice.domain.Organization;
import com.stackroute.indexerservice.domain.User;
import com.stackroute.indexerservice.domain.input.CommonOutput;
import com.stackroute.indexerservice.domain.input.Property;
import com.stackroute.indexerservice.domain.relationships.CertificateRelationshipProperty;
import com.stackroute.indexerservice.repository.CertifiedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CertificateServiceImpl implements CertificateService{
    @Autowired
    private CertifiedRepository certifiedRepository;
    @Autowired
    private User user;
    @Autowired
    private Organization organization;
    private Map<String,String> prop;
    private String key;
    private String value;
    private Property[] property;
    public CertificateServiceImpl(){
        prop = new HashMap<>();
    }

    public void createNode(CommonOutput commonOutput) {
        user.setUserId(commonOutput.getSourceNode());
        for (int i = 0; i < commonOutput.getTargetNodeProperty().length; i++)
        {
            organization.setName(commonOutput.getTargetNodeProperty()[i].getName());
            CertificateRelationshipProperty certificateRelationshipProperty= new CertificateRelationshipProperty();
            certificateRelationshipProperty.setRelationship(commonOutput.getRelationships());
            certificateRelationshipProperty.setUser(user);
            certificateRelationshipProperty.setOrganization(organization);
            property = commonOutput.getProperties();
            for (int j = 0; j < property.length; j++) {
                key = property[j].getPropertyName();
                value = property[j].getPropertyValue();
                prop.put(key, value);
            }
            certificateRelationshipProperty.setProperties(prop);
            certifiedRepository.save(certificateRelationshipProperty);
        }
    }

    public void deleteNode(CommonOutput commonOutput){
        user.setUserId(commonOutput.getSourceNode());
        for (int i = 0; i < commonOutput.getTargetNodeProperty().length; i++)
        {
            organization.setName(commonOutput.getTargetNodeProperty()[i].getName());
            CertificateRelationshipProperty certificateRelationshipProperty= new CertificateRelationshipProperty();
            certificateRelationshipProperty.setRelationship(commonOutput.getRelationships());
            certificateRelationshipProperty.setUser(user);
            certificateRelationshipProperty.setOrganization(organization);
            property = commonOutput.getProperties();
            for (int j = 0; j < property.length; j++) {
                key = property[j].getPropertyName();
                value = property[j].getPropertyValue();
                prop.put(key, value);
            }
            certificateRelationshipProperty.setProperties(prop);
            certifiedRepository.deleteById(certificateRelationshipProperty.getRelationship());
        }
    }

    public void updateNode(CommonOutput commonOutput) {
        user.setUserId(commonOutput.getSourceNode());
        for (int i = 0; i < commonOutput.getTargetNodeProperty().length; i++)
        {
            organization.setName(commonOutput.getTargetNodeProperty()[i].getName());
            CertificateRelationshipProperty certificateRelationshipProperty= new CertificateRelationshipProperty();
            certificateRelationshipProperty.setRelationship(commonOutput.getRelationships());
            certificateRelationshipProperty.setUser(user);
            certificateRelationshipProperty.setOrganization(organization);
            property = commonOutput.getProperties();
            for (int j = 0; j < property.length; j++) {
                key = property[j].getPropertyName();
                value = property[j].getPropertyValue();
                prop.put(key, value);
            }
            certificateRelationshipProperty.setProperties(prop);
            certifiedRepository.save(certificateRelationshipProperty);
        }
    }

}
