package com.example.myproject.service.impl;

import com.example.myproject.dto.TransactionDto;
import com.example.myproject.dto.UserDto;
import com.example.myproject.entity.UserEntity;
import com.example.myproject.repository.UserRepository;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository repository;

    @Override
    public UserEntity CreateUser(UserDto userDto)
    {
        UserEntity userEntity = new UserEntity();

        userEntity.setName(userDto.getName());
        userEntity.setMoney(userDto.getMoney());

        return repository.save(userEntity);
    }

    @Override
    public List<UserEntity> GetAllUsers()
    {
        return repository.findAll();
    }

    @Override
    public UserEntity GetUserById(int userId)
    {
        return repository.findById(userId).orElse(null);
    }

    @Override
    public UserEntity UpdateUser(TransactionDto transactionDto)
    {
        //Get user
        UserEntity userEntity = GetUserById(transactionDto.getUserId());

        //Update money
        userEntity.setMoney(userEntity.getMoney() + transactionDto.getTransaction());

        //Save it
        return repository.save(userEntity);
    }
}
