package com.example.myproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class UserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name cannot be longer than 100 characters")
    private String name;

    @Column(columnDefinition = "integer default 0")
    private int money;

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getMoney()
    {
        return money;
    }
    public void setMoney(int money)
    {
        this.money = money;
    }
}
