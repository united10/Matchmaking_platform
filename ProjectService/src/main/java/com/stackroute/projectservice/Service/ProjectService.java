package com.stackroute.projectservice.Service;

import com.stackroute.projectservice.domain.CommonOutput;
import com.stackroute.projectservice.domain.Project;

public interface ProjectService {
    CommonOutput processProjectDetails(Project project);
}
