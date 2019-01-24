package com.aip.servlet.controller;

import com.aip.servlet.exception.DaoException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(DaoException.class)
    public String catchDaoException(Model model, DaoException ex) {
        model.addAttribute("errorMessage", "Dao exception");
        return "error";
    }
}
