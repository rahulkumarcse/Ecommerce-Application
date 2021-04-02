package com.rahul.ecommerce.backend.service;

import com.rahul.ecommerce.backend.dao.UserRepository;
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
}
