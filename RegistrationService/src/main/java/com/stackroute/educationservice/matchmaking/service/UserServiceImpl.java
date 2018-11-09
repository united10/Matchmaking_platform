package com.stackroute.educationservice.matchmaking.service;

import com.stackroute.educationservice.matchmaking.domain.User;
import com.stackroute.educationservice.matchmaking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user){
        User savedUser= userRepository.save(user);
        return savedUser;
    }
}
