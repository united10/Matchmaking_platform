package com.stackroute.projectservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*  project details class*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDetails {
    private String title;
    private String fromDate;
    private String toDate;
    private String projectUrl;
    private String role;
    private Skill[] technologiesUsed;
    private String description;
}
