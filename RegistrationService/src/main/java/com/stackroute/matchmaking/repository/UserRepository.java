package com.stackroute.matchmaking.repository;

import com.stackroute.matchmaking.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}