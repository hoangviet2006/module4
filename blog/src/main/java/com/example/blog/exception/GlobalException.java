package com.example.blog.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(NoHandlerFoundException.class)
    public String notFound() {
        return "";
    }
}
