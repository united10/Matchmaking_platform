package com.stackroute.educationservice.springskill.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonOutput {
    private String operationType;
    private String sourceNode;
    private String SourceNodeProperties;
    private String terminalNode;
    private String terminalNodeProperties;
    private Relationship relationship[];

}