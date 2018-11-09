package com.stackroute.matchmaking.Repository;

import com.stackroute.matchmaking.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}