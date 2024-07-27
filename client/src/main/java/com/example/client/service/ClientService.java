package com.example.client.service;

import com.example.client.dto.TransactionDto;
import com.example.client.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ClientService
{
    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/api/";

    public UserDto addUser(UserDto userDto)
    {
        return restTemplate.postForObject(BASE_URL + "user/add", userDto, UserDto.class);
    }

    public List<UserDto> getAllUsers()
    {
        UserDto[] users = restTemplate.getForObject(BASE_URL + "users", UserDto[].class);
        return Arrays.asList(users);
    }

    public UserDto getUser(int userId)
    {
        return restTemplate.getForObject(BASE_URL + "user/" + userId, UserDto.class);
    }

    public int checkMoney(int userId)
    {
        return restTemplate.getForObject(BASE_URL + "money/check/" + userId, Integer.class);
    }

    public UserDto updateMoney(TransactionDto transactionDto)
    {
        return restTemplate.postForObject(BASE_URL + "money/update", transactionDto, UserDto.class);
    }
}
