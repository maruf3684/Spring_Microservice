package com.lcwd.user_service.services;

import com.lcwd.user_service.entities.User;
import com.lcwd.user_service.repositories.UserRepository;

import java.util.List;

public interface UserService {

    //create user
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user
    User getUser(String userId);
}
