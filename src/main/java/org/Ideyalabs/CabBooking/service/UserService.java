package org.Ideyalabs.CabBooking.service;


import org.Ideyalabs.CabBooking.dto.BookingDTO;
import org.Ideyalabs.CabBooking.dto.UserDTO;
import org.Ideyalabs.CabBooking.exception.UpdateUserByIdDoesNotExistException;

import java.util.List;

public interface UserService {



   public List<UserDTO> getAllUsers();

   public UserDTO getUserBYId(int userid);


    public void updateUserById(int userid, UserDTO userDTO);

    public  String deleteUserById(int userid);

    public String loginUser(UserDTO userDTO);

    BookingDTO bookCab(UserDTO userDTO);
}

