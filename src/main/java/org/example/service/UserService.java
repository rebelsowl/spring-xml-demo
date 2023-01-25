package org.example.service;

import org.example.data.model.dto.UserDto;

import java.util.List;

public interface UserService {

    List getAllUsers();
    UserDto getUser(int id);
    UserDto createUser(UserDto user);
    void updateUser(UserDto user);
    void deleteUser(int id);

}
