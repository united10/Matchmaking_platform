package com.stackroute.indexerservice.repository;

import com.stackroute.indexerservice.domain.relationships.EducationRelationshipProperty;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EducatedRepository extends Neo4jRepository<EducationRelationshipProperty,String> {
}
