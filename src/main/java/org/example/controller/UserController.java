package org.example.controller;


import org.example.data.model.dto.UserDto;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }

    @GetMapping("/users")
    public List getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserDto getUserWithId(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @PostMapping("/user")
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserDto userDto){
        userService.updateUser(userDto);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }



}