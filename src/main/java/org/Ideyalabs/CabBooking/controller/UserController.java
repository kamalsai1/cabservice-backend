package org.Ideyalabs.CabBooking.controller;


import org.Ideyalabs.CabBooking.dto.BookingDTO;
import org.Ideyalabs.CabBooking.dto.DriverDto;
import org.Ideyalabs.CabBooking.dto.UserDTO;
import org.Ideyalabs.CabBooking.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user-api/v1")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        logger.info("Retrieving all users");
        return  userService.getAllUsers();
    }
    @GetMapping("/users/{userid}")
    public UserDTO getUserById(@PathVariable("userid") int userid){
        logger.info("Retrieving user by id: {} ", userid);
        return userService.getUserBYId(userid);
    }
    @PutMapping("/users/{userid}")
    public void updateUserById(@PathVariable("userid") int userid ,@RequestBody UserDTO userDTO){
        logger.info("Updating user by id: {} ", userid);
        userService.updateUserById(userid,userDTO);
    }
    @DeleteMapping("/users/{userid}")
    public String deleteUserById(@PathVariable("userid")  int userid){
        logger.info("Deleting user by id: {} ", userid);
        return userService.deleteUserById(userid);
    }

    @PostMapping("/users/login")
    public String loginUser(@RequestBody UserDTO userDTO){
        logger.info("Logging in user: {} ", userDTO.getUsername());
        return userService.loginUser(userDTO);
    }

    @PostMapping("/users/bookCab")
    public BookingDTO bookCab(@RequestBody UserDTO userDTO){
        logger.info("Booking cab for user: {} ", userDTO.getUsername());
        return userService.bookCab(userDTO);
    }
}

