package com.smartReminder.User_Management.service;

import com.smartReminder.User_Management.dto.RegisterDto;
import com.smartReminder.User_Management.model.User;
import com.smartReminder.User_Management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public User registerUser(RegisterDto registerDto) {
        return userRepository.save(registerDto);
    }

    public User findById(String id) {
        return userRepository.findById(id);
    }

    public User findByEmail(String id, String email) {
        return userRepository.findByEmail(id, email);
    }

    public User updateUser(String id, RegisterDto registerDto) {
        return userRepository.updateUser(id,registerDto);
    }




}
