package com.example.testrestapi.exceptions;

import java.time.LocalTime;
import java.util.Date;

public class UserException {
    private String message;
    private Date timeError;



    public UserException(String message, Date timeError) {
        this.message = message;
        this.timeError = timeError;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimeError() {
        return timeError;
    }

    public void setTimeError(Date timeError) {
        this.timeError = timeError;
    }
}
