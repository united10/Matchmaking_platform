package com.stackroute.projectservice.service;

import com.stackroute.projectservice.domain.CommonOutput;
import com.stackroute.projectservice.domain.Section;

public interface ProjectService {
    CommonOutput processProjectDetails(Section section);
}
