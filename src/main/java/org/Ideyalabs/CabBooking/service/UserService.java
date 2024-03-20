package org.Ideyalabs.CabBooking.service;


import org.Ideyalabs.CabBooking.dto.UserDTO;
import org.Ideyalabs.CabBooking.exception.UpdateUserByIdDoesNotExistException;

import java.util.List;

public interface UserService {

    public  UserDTO createUser(UserDTO userDto);

   public List<UserDTO> getAllUsers();

   public UserDTO getUserBYId(int userid);


    public void updateUserById(int userid, UserDTO userDTO);

    public  String deleteUserById(int userid);
}

