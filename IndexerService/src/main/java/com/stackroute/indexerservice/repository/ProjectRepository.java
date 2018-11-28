package com.stackroute.indexerservice.repository;


import com.stackroute.indexerservice.domain.relationships.ProjectRelationshipProperty;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends Neo4jRepository<ProjectRelationshipProperty,String> {
    @Query("MATCH (a:Project),(b:Project)\n" +
            "WHERE a.name = 'project' AND b.name = {name} \n" +
            "CREATE (a)-[r:has_a]->(b)\n" +
            "RETURN type(r)")
    public void saveNode(@Param("name") String name);
}
