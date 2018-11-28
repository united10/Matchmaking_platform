package com.stackroute.indexerservice.repository;

import com.stackroute.indexerservice.domain.relationships.ExperienceRelationshipProperty;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface WorksRepository extends Neo4jRepository<ExperienceRelationshipProperty,String> {
}
