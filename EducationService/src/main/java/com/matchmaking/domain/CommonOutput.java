package com.matchmaking.domain;

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
    private String sourceProperties;
    private String terminalNode;
    private String terminalProperties;
    private Relationship[] relationship;
}
