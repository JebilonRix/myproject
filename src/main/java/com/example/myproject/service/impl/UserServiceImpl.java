package com.example.myproject.service.impl;

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
    public UserEntity Create(UserEntity userEntity)
    {
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
    public UserEntity Update(UserEntity userEntity)
    {
        return repository.save(userEntity);
    }

    @Override
    public UserEntity Test(int userId)
    {
        UserEntity currentUser = GetUserById(userId);

        int currentMoney = currentUser.getMoney() + 150;

        currentUser.setMoney(currentMoney);

        return repository.save(currentUser);
    }
}
