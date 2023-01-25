package org.example.service.Impl;

import org.example.data.model.dao.UserDao;
import org.example.data.model.dto.UserDto;
import org.example.data.model.entity.UserEntity;
import org.example.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public UserDto getUser(int id) {
        UserDto user = new UserDto();
        UserEntity foundUser = userDao.getUser(id);
        BeanUtils.copyProperties(foundUser, user);
        return user;
    }

    @Transactional
    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);

        UserEntity savedUser = userDao.addUser(userEntity);

        UserDto returnUser = new UserDto();
        BeanUtils.copyProperties(savedUser, returnUser);
        return returnUser;
    }

    @Transactional
    @Override
    public void updateUser(UserDto user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        userDao.updateUser(userEntity);

    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
