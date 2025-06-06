package com.apuliadigital.corsospring.service;

import com.apuliadigital.corsospring.model.User;
import com.apuliadigital.corsospring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public boolean deleteUserById(int id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public User updateUser(int id, User updatedUser){
        if(userRepository.existsById(id)){
            updatedUser.setId(id);
            return userRepository.save(updatedUser);
        }
        return null;
    }
}
