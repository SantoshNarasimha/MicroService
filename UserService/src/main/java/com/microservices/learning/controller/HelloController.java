package com.microservices.learning.controller;

import com.microservices.learning.entity.User;
import com.microservices.learning.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private UserService userService;

    // saving user details

    @PostMapping("/save")
    public ResponseEntity<User> home(@RequestBody User user){
        log.info("Received save request for user: {}", user.getName());
        long startTime = System.currentTimeMillis();
        User user1 = userService.saveUser(user);
        long endTime = System.currentTimeMillis();
        log.info("User saved successfully in {} ms", endTime - startTime);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    // get all users

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> users(){
        List<User> users = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    // get user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getuserbyid(@PathVariable String id) {
        User user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    



}