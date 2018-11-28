package com.stackroute.indexerservice.repository;

import com.stackroute.indexerservice.domain.relationships.SkillRelationshipProperty;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SkillRepository extends Neo4jRepository<SkillRelationshipProperty,String> {

}
