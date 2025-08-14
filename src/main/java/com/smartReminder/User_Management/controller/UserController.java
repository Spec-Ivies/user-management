package com.smartReminder.User_Management.controller;

import com.smartReminder.User_Management.dto.RegisterDto;
import com.smartReminder.User_Management.model.User;
import com.smartReminder.User_Management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public User register(@RequestBody RegisterDto registerDto) {
        return userService.registerUser(registerDto);
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public User findById(@PathVariable String userId) {
        return userService.findById(userId);
    }

    @GetMapping("/userId/{id}")
    @ResponseBody
    public User findByEmail(@PathVariable String id, @RequestParam(name = "email") String email) {
        return userService.findByEmail(id, email);
    }

    @PutMapping("/{userId}/update")
    @ResponseBody
    public User updateUser(@PathVariable String userId,@RequestBody RegisterDto registerDto) {
        return userService.updateUser(userId, registerDto);
    }
}
