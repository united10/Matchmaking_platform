package com.matchmaking.service;

import com.matchmaking.domain.CommonOutput;
import com.matchmaking.domain.Section;
import org.springframework.stereotype.Service;

public interface EducationService {
    //TODO: have to change return type
    CommonOutput processEducationDetails(Section section);
}
