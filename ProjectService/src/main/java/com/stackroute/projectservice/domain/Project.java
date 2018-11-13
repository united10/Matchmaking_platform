package com.stackroute.educationservice.projectservice.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    private String sectionId;
    private String userId;
    private String operationType;
    private Chicklets chicklets;
}
