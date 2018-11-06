package com.stackroute.springskill.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Relationship {
    private String relationshipProperty;
    private String relationshipType;

}
