package com.example.testrestapi.exceptions;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalTime;
import java.util.Date;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<UserException> userNotFoundException(UserNotFoundException e){
        UserException userException = new UserException(e.getMessage(), new Date());
        return new ResponseEntity<>(userException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = UserIsNotCorrect.class)
    public ResponseEntity<UserException> userIsNotCorrect(UserIsNotCorrect e){
        UserException userException = new UserException(e.getMessage(), new Date());
        return new ResponseEntity<>(userException, HttpStatus.CONFLICT);
    }
}
