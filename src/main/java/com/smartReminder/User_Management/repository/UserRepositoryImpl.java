package com.smartReminder.User_Management.repository;

import com.smartReminder.User_Management.dto.RegisterDto;
import com.smartReminder.User_Management.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;

@Component
public class UserRepositoryImpl implements UserRepository {

    private HashMap<String, User> userHashMap = new HashMap<>();

    @Override
    public User save(RegisterDto userDto) {
        User user = new User();
        // Use UUID to generate random userId;
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        setUserObject(userDto, user);

        // Save user into map
        userHashMap.put(userId, user);
        return user;
    }

    private void setUserObject(RegisterDto userDto, User user) {
        user.setName(userDto.getName());
        user.setEmailAddress(userDto.getEmailAddress());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());
    }

    @Override
    public User findById(String id) {
        User user  = userHashMap.get(id);
        return user;
    }

    @Override
    public User findByEmail(String id, String email) {
        User user = userHashMap.get(id);
        if(email.equals(user.getEmailAddress())){
            return user;
        }
        return null;
    }

    @Override
    public User updateUser(String id, RegisterDto dto) {
        User user = userHashMap.get(id);
        setUserObject(dto, user);

        userHashMap.put(id, user);
        return user;
    }
}
