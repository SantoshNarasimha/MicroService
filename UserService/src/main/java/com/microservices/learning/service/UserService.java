package com.microservices.learning.service;

import com.microservices.learning.entity.User;
import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUserById(String userId);

    User deleteUser(String userId);

    User updateUser(User user);

}