package com.stackroute.locationservice.service;

import com.stackroute.locationservice.domain.CommonOutput;
import com.stackroute.locationservice.domain.Section;

/*It is an interface for the location service
for loosely coupling and changes for future*/
public interface LocationService {
    CommonOutput processLocationDetails(Section section);
}
