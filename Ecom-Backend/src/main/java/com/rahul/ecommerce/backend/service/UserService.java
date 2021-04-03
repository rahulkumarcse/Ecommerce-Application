package com.rahul.ecommerce.backend.service;

import com.rahul.ecommerce.backend.dao.UserRepository;
import com.rahul.ecommerce.backend.dto.UserLoginDto;
import com.rahul.ecommerce.backend.dto.UserProfileDto;
import com.rahul.ecommerce.backend.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public List<Users> getallUsers(){
        return userRepository.getallUsersDetails();
    }

    public UserProfileDto addUser(Users user){
        return userRepository.addUser(user);
    }
    public UserProfileDto loginUser(UserLoginDto user){
        return userRepository.loginUser(user);
    }
}
