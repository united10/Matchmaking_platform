package com.stackroute.educationservice.matchmaking.controller;

import com.stackroute.educationservice.matchmaking.domain.User;
import com.stackroute.educationservice.matchmaking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value="/registration/ap1/v1")
public class UserController {
    @Autowired
    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    private KafkaTemplate<String, User> kafkaTemplate;
    private  static final String TOPIC ="user";

    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        ResponseEntity responseEntity;
        try{
            kafkaTemplate.send(TOPIC,user);
            responseEntity=new ResponseEntity<String>( "Successfully created", HttpStatus.CREATED);
        }
        catch(Exception ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
