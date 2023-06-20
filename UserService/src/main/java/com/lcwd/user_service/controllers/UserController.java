package com.lcwd.user_service.controllers;
import com.lcwd.user_service.entities.User;
import com.lcwd.user_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
      User newUser = userService.saveUser(user);
      return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
       List<User> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }
}
