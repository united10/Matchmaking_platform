package com.stackroute.cacheservice.service;

import com.stackroute.cacheservice.domain.education;
import com.stackroute.cacheservice.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EducationService {

    EducationRepository educationRepository;
    @Autowired
    public EducationService( EducationRepository educationRepository){
        this.educationRepository=educationRepository;
    }


    public List<education> getAlleducation(){
        //System.out.println("hjsdjskdjskdjsk" + educationRepository.getAllEducation());
        return educationRepository.getAllEducation();
    }

    public List<education> getAllQualification(){
        return educationRepository.getAllQualification();
    }
}
