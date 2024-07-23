package com.example.myproject.service;

import com.example.myproject.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService
{
    public UserEntity Create(UserEntity userEntity);

    public List<UserEntity> GetAllUsers();

    public UserEntity GetUserById(int userId);

    public UserEntity Update(UserEntity userEntity);

    public UserEntity Test(int userId);
}
