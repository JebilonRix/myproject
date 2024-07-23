package com.example.myproject.controller;

import com.example.myproject.dto.TransactionDto;
import com.example.myproject.dto.UserDto;
import com.example.myproject.entity.UserEntity;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping(path = "user/add")
    public ResponseEntity<UserEntity> AddUser(@RequestBody UserDto userDto)
    {
        try
        {
            System.out.println("AddUser is called");

            // Get name
            String name = userDto.getName();

            if(name == null || name.isEmpty())
            {
                System.out.println("AddUser: Name is null or empty");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            //Get money
            int money = userDto.getMoney();

            if(money < 0)
            {
                System.out.println("AddUser: Money can not be less than 0");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            UserEntity entity = userService.CreateUser(userDto);
            return ResponseEntity.ok(entity);
        }
        catch(Exception e)
        {
            System.out.println("AddUser: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "users")
    public ResponseEntity<List<UserEntity>> GetAllUsers()
    {
        System.out.println("GetAllUsers is called");
        return ResponseEntity.ok(userService.GetAllUsers());
    }

    @GetMapping(path = "user/{userId}")
    public ResponseEntity<UserEntity> GetUser(@PathVariable("userId") int userId)
    {
        try
        {
            System.out.println("GetUser is called, id: " + userId);

            //null check
            UserEntity userEntity = GetUserEntity(userId).getBody();

            return ResponseEntity.ok(userEntity);
        }
        catch(Exception e)
        {
            System.out.println("GetUser: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "money/check/{userId}")
    public ResponseEntity<Integer> CheckMoney(@PathVariable("userId") int userId)
    {
        try
        {
            System.out.println("CheckMoney is called");

            //null check
            UserEntity userEntity = GetUserEntity(userId).getBody();

            return ResponseEntity.ok(userEntity.getMoney());
        }
        catch(Exception e)
        {
            System.out.println("CheckMoney: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "money/update")
    public ResponseEntity<UserEntity> UpdateMoney(@RequestBody TransactionDto transactionDto)
    {
        try
        {
            System.out.println("UpdateMoney is called");

            //null check
            UserEntity userEntity = GetUserEntity(transactionDto.getUserId()).getBody();

            return ResponseEntity.ok(userService.UpdateUser(transactionDto));
        }
        catch(Exception e)
        {
            System.out.println("UpdateMoney: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ResponseEntity<UserEntity> GetUserEntity(int userId)
    {
        UserEntity userEntity = userService.GetUserById(userId);

        if(userEntity == null)
        {
            System.out.println("User not found, id: " + userId);
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("anan");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(userEntity);
    }
}