package com.stackroute.projectservice.service;

import com.stackroute.projectservice.domain.CommonOutput;
import com.stackroute.projectservice.domain.Section;

/*It is an interface for the certificate service*/
public interface ProjectService {
    CommonOutput processProjectDetails(Section section);
}
