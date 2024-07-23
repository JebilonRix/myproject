package com.example.myproject.controller;

import com.example.myproject.dto.TransactionDto;
import com.example.myproject.entity.UserEntity;
import com.example.myproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping(path = "user/add")
    public ResponseEntity<UserEntity> AddUser(@RequestBody UserEntity userEntity)
    {
        try
        {
            System.out.println("AddUser is called");

            // Get name
            String name = userEntity.getName();

            if(name == null || name.isEmpty())
            {
                System.out.println("AddUser: Name is null or empty");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            //Get money
            int money = userEntity.getMoney();

            if(money < 0)
            {
                System.out.println("AddUser: Money can not be less than 0");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            UserEntity entity = userService.Create(userEntity);

            // If the user is found, return it with a 200 OK status
            return ResponseEntity.ok(entity);
        }
        catch(Exception e)
        {
            System.out.println("AddUser: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "user/{userId}")
    public ResponseEntity<UserEntity> GetUser(@PathVariable("userId") int userId)
    {
        try
        {
            System.out.println("GetUser is called, id: " + userId);

            // Try to get user by id
            UserEntity user = userService.GetUserById(userId);

            if(user == null)
            {
                System.out.println("GetUser: User is null");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch(Exception e)
        {
            System.out.println("GetUser: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "users")
    public ResponseEntity<List<UserEntity>> GetAllUsers()
    {
        System.out.println("get all users");
        return ResponseEntity.ok(userService.GetAllUsers());
    }

    @GetMapping(path = "check-money/{userId}")
    public String CheckMoney(@PathVariable("userId") int userId)
    {
        System.out.println("CheckMoney id: " + userId);
        return String.valueOf(userService.GetUserById(userId).getMoney());
    }

    @PutMapping(path = "add-money")
    public UserEntity AddMoney(@RequestBody UserEntity user)
    {
        System.out.println("AddMoney id: " + user.getId());
        return userService.Update(user);
    }

    @PutMapping(path = "withdraw-money/{userId}")
    public UserEntity WithdrawMoney(@PathVariable("userId") int userId)
    {
        System.out.println("WithdrawMoney id: " + userId);
        return userService.Test(userId);
    }
}
