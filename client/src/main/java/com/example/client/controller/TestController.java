package com.example.client.controller;

import com.example.client.dto.TransactionDto;
import com.example.client.dto.UserDto;
import com.example.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController
{
    @Autowired
    private ClientService clientService;

    @PostMapping("/test/addUser")
    public UserDto addUser(@RequestBody UserDto userDto)
    {
        return clientService.addUser(userDto);
    }

    @GetMapping("/test/users")
    public List<UserDto> getAllUsers()
    {
        return clientService.getAllUsers();
    }

    @GetMapping("/test/user/{userId}")
    public UserDto getUser(@PathVariable int userId)
    {
        return clientService.getUser(userId);
    }

    @GetMapping("/test/money/check/{userId}")
    public int checkMoney(@PathVariable int userId)
    {
        return clientService.checkMoney(userId);
    }

    @PostMapping("/test/money/update")
    public UserDto updateMoney(@RequestBody TransactionDto transactionDto)
    {
        return clientService.updateMoney(transactionDto);
    }
}
