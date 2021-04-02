package com.rahul.ecommerce.backend.controller;

import com.rahul.ecommerce.backend.dao.UserRepository;
import com.rahul.ecommerce.backend.entity.Users;
import com.rahul.ecommerce.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping(value ="/user" , produces = "application/json")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method=RequestMethod.GET , value="/users")
    List<Users> getallUserDetails(){
       return userService.getallUsers();
    }


    @RequestMapping(method = RequestMethod.POST,value ="/registration")
    public void addUser(@RequestBody Users user){
        userRepository.addUser(user);
    }


}
