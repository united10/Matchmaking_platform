package com.stackroute.locationservice.service;

import com.stackroute.locationservice.domain.CommonOutput;
import com.stackroute.locationservice.domain.Section;

public interface LocationService {
    CommonOutput processLocationDetails(Section section);
}
