package org.Ideyalabs.CabBooking.service;


import lombok.SneakyThrows;
import org.Ideyalabs.CabBooking.dto.BookingDTO;
import org.Ideyalabs.CabBooking.dto.UserDTO;
import org.Ideyalabs.CabBooking.exception.UpdateUserByIdDoesNotExistException;
import org.Ideyalabs.CabBooking.exception.UserByIdDoesNotExistException;
import org.Ideyalabs.CabBooking.model.User;
import org.Ideyalabs.CabBooking.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDtoList=userRepository.findAll()
                .stream()
                .map(e->modelMapper.map(e, UserDTO.class))
                .collect(Collectors.toList());

        return userDtoList;

    }

    @SneakyThrows
    @Override
    public UserDTO getUserBYId(int userid) {
        Optional<User> userOptional = userRepository.findById(userid);
        if(userOptional.isEmpty()){
            throw  new UserByIdDoesNotExistException("Id is not found");
        }
        return modelMapper.map(userOptional.get(), UserDTO.class);
    }

    @SneakyThrows
    @Override
    public void updateUserById(int userid, UserDTO userDTO) {
        Optional<User> userOptional= userRepository.findById(userid);
        if(userOptional.isPresent()){
            User existData = userOptional.get();
            existData.setUsername(userDTO.getUsername());
            existData.setPassword(userDTO.getPassword());
            existData.setEmail(userDTO.getEmail());
            existData.setPhone(userDTO.getPhone());
            userRepository.save(existData);
        }
        else{
            throw new UpdateUserByIdDoesNotExistException("Cannot update : Id not present");
        }

    }

    @Override
    public String deleteUserById(int userid) {
        boolean DeleteUser = userRepository.existsById(userid);
        if(DeleteUser){
            userRepository.deleteById(userid);
            return "User id " + userid + " deleted successfully";
        }
        return "User  id"+" "+userid+" does not exists in the db";
    }

    @Override
    public String loginUser(UserDTO userDTO) {
        List<User> user = userRepository.findAll();
        for(User u : user){
            if(u.getUsername().equals(userDTO.getUsername()) && u.getPassword().equals(userDTO.getPassword())){
                return "Login Successful";
            }
        }
        return "Login Unsuccessful";
    }

    @Override
    public BookingDTO bookCab(UserDTO userDTO) {
        return null;
    }

}

