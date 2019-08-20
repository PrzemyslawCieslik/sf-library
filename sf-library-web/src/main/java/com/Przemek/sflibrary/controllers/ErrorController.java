package com.Przemek.sflibrary.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping("/error")
    public String handleException(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null){
            String string;
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()){
                return "/errors/error404";
            }
            else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){
                return "/errors/error500";
            }
        }
        return "/errors/error";

    }

    @Override
    public String getErrorPath() {
        return "/errors/error";
    }
}
