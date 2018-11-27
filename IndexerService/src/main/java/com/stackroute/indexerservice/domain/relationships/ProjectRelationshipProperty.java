package com.stackroute.indexerservice.domain.relationships;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.RelationshipEntity;

@Data
@Builder
//@NoArgsConstructor
@AllArgsConstructor
@RelationshipEntity(type = "project-in")
public class ProjectRelationshipProperty {

}
