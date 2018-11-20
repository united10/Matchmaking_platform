package com.stackroute.educationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
 *  CommonOutput class is for sending output to kafka
 *  indexer topic in this format.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonOutput {

    private String operationType;
    private String sourceNode;
    private String sourceNodeProperties;
    private String terminalNode;
    private String terminalNodeProperties;
    private Relationships[] relationships;

}
