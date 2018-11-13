package com.stackroute.DownstreamService.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationSection {
    private String sectionId;
    private String userId;
    private String operationType;
    private Chicklets[] chicklets;

}
