package com.stackroute.indexerservice.repository;

import com.stackroute.indexerservice.domain.relationships.InterestRelationshipProperty;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface InterestRepository extends Neo4jRepository<InterestRelationshipProperty,String> {
}
