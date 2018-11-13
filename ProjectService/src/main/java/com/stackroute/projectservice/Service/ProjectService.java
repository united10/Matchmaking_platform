package com.stackroute.educationservice.projectservice.Service;

import com.stackroute.educationservice.projectservice.domain.CommonOutput;
import com.stackroute.educationservice.projectservice.domain.Project;

public interface ProjectService {
    CommonOutput processProjectDetails(Project project);
}
