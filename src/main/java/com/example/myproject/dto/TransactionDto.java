package com.example.myproject.dto;

public class TransactionDto
{
    private int userId;
    private int transaction;

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getTransaction()
    {
        return transaction;
    }

    public void setTransaction(int transaction)
    {
        this.transaction = transaction;
    }
}
