package com.stackroute.educationservice.springlocation.Service;

import com.stackroute.educationservice.springlocation.domain.CommonOutput;
import com.stackroute.educationservice.springlocation.domain.Section;

public interface LocationService {
    CommonOutput processLocationDetails(Section section);
}
