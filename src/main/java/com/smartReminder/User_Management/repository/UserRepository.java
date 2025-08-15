package com.smartReminder.User_Management.repository;

import com.smartReminder.User_Management.dto.RegisterDto;
import com.smartReminder.User_Management.model.User;

import java.util.List;


public interface UserRepository {

    User save(RegisterDto userDto);

    User findById(String id);

    User findByEmail(String id, String email);

    User updateUser(String id, RegisterDto dto);

    List<User> findAllUsers(); // New method to retrieve all users

}
