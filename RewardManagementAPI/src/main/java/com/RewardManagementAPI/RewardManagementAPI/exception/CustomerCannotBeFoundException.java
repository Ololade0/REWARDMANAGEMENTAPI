package com.RewardManagementAPI.RewardManagementAPI.exception;

public class CustomerCannotBeFoundException extends RuntimeException{
    public CustomerCannotBeFoundException(String Message) {
        super(Message);
    }
}
