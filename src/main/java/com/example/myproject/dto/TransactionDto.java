package com.example.myproject.dto;

public class TransactionDto extends UserDto
{
    private int transaction;

    public int getTransaction()
    {
        return transaction;
    }
    public void setTransaction(int transaction)
    {
        this.transaction = transaction;
    }
}
