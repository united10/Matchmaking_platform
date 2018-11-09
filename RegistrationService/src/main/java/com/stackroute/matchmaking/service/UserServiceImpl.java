package com.stackroute.matchmaking.service;

import com.stackroute.matchmaking.repository.UserRepository;
import com.stackroute.matchmaking.domain.User;
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
