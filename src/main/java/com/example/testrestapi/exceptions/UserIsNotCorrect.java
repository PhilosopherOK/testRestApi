package com.example.testrestapi.exceptions;

public class UserIsNotCorrect extends RuntimeException{
    public UserIsNotCorrect(String message) {
        super(message);
    }
}
