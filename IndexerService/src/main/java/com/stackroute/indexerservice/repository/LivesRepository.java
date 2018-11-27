package com.stackroute.indexerservice.repository;

import com.stackroute.indexerservice.domain.relationships.LocationRelationshipProperty;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface LivesRepository extends Neo4jRepository<LocationRelationshipProperty,String> {
}
