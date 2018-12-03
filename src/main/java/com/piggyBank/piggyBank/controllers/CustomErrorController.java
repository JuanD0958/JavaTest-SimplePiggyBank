package com.piggyBank.piggyBank.controllers;

import com.piggyBank.piggyBank.exceptions.ExceptionMessages;
import com.piggyBank.piggyBank.exceptions.ServicePathException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public void handleError() {
        throw new ServicePathException(ExceptionMessages.SERVICE_NOT_EXIST);
    }

    @Override
    public String getErrorPath() {
        return "/";
    }
}