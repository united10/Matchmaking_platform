package com.stackroute.educationservice.matchMaking.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
//import com.stackroute.matchMaking.domain.RelationProperties;

//import javax.persistence.Entity;

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
