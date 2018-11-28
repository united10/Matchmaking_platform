package com.stackroute.indexerservice.repository;


import com.stackroute.indexerservice.domain.relationships.CertificateRelationshipProperty;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CertifiedRepository extends Neo4jRepository<CertificateRelationshipProperty,String> {
}
