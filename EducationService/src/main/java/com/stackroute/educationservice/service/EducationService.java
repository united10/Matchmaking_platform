package com.stackroute.educationservice.service;

import com.stackroute.educationservice.domain.CommonOutput;
import com.stackroute.educationservice.domain.Section;

public interface EducationService {
    CommonOutput processEducationDetails(Section section);
}
