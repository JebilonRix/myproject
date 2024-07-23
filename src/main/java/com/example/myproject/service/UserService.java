package com.example.myproject.service;

import com.example.myproject.dto.TransactionDto;
import com.example.myproject.dto.UserDto;
import com.example.myproject.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService
{
    public UserEntity CreateUser(UserDto userDto);

    public List<UserEntity> GetAllUsers();

    public UserEntity GetUserById(int userId);

    public UserEntity UpdateUser(TransactionDto transactionDto);
}
