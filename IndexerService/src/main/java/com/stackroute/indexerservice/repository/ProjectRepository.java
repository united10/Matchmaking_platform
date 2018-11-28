package com.stackroute.indexerservice.repository;


import com.stackroute.indexerservice.domain.relationships.ProjectRelationshipProperty;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface ProjectRepository extends Neo4jRepository<ProjectRelationshipProperty,String> {
//    @Query("")
//    public void saveNode(ProjectRelationshipProperty projectRelationshipProperty);
}
