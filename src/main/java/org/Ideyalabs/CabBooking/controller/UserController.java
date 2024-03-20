package org.Ideyalabs.CabBooking.controller;


import org.Ideyalabs.CabBooking.dto.UserDTO;
import org.Ideyalabs.CabBooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/users")
    public UserDTO createUser(@RequestBody UserDTO userDto){

        return  userService.createUser(userDto);
    }
    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return  userService.getAllUsers();
    }
    @GetMapping("/users/{userid}")
    public UserDTO getUserById(@PathVariable("userid") int userid){
        return userService.getUserBYId(userid);
    }
    @PutMapping("/users/{userid}")
    public void updateUserById(@PathVariable("userid") int userid ,@RequestBody UserDTO userDTO){
        userService.updateUserById(userid,userDTO);
    }
    @DeleteMapping("/users/{userid}")
    public String deleteUserById(@PathVariable("userid")  int userid){
        return userService.deleteUserById(userid);
    }
}

