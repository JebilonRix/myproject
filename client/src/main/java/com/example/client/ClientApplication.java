package com.example.client;

import com.example.client.dto.TransactionDto;
import com.example.client.dto.UserDto;
import com.example.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner
{
    @Autowired
    private ClientService clientService;

    public static void main(String[] args)
    {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        // Kullanıcı ekle
        //        UserDto newUser = new UserDto();
        //        newUser.setName("John Doe");
        //        newUser.setMoney(100);
        //        UserDto addedUser = clientService.addUser(newUser);
        //        System.out.println("Added User: " + addedUser);

        // Tüm kullanıcıları getir
        List<UserDto> users = clientService.getAllUsers();
        System.out.println("All Users:");
        users.forEach(user -> System.out.println("User Name: " + user.getName()));

        // Belirli bir kullanıcıyı getir
        UserDto user = clientService.getUser(1);
        System.out.println("User with ID 1: " + user);

        // Kullanıcı parası kontrol et
        int money = clientService.checkMoney(1);
        System.out.println("Money of user with ID 1: " + money);

        // Kullanıcı parası güncelle
        TransactionDto transaction = new TransactionDto();
        transaction.setUserId(1);
        transaction.setAmount(50);
        UserDto updatedUser = clientService.updateMoney(transaction);
        System.out.println("Updated User: " + updatedUser);
    }
}
