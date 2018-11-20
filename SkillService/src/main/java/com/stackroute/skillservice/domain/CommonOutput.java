package com.stackroute.skillservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*Common output which is to be send to indexer*/
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
    private Relationship[] relationship;

}