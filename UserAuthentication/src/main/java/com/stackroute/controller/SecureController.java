package com.stackroute.controller;

import com.stackroute.domain.User;
import com.stackroute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Authorization using jwt token and updating user details.

@RestController
@CrossOrigin("*")
@RequestMapping("/secure")
public class SecureController {

   private UserService userService;

    @Autowired
    public SecureController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user/users")
    public String loginSuccess() {
        return "Login Successful!";
    }

    @RequestMapping(value = "/user/email", method = RequestMethod.POST)
    public User findByEmail(@RequestBody String email)
    {
        System.out.println("secure");
        System.out.println(userService.findByEmail(email));
        return userService.findByEmail(email);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        System.out.println(user);
        return userService.save(user);
    }
}
