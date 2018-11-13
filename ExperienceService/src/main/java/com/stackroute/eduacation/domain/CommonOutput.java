package com.stackroute.matchmaking.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
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
    private Relationships relationships;

}
