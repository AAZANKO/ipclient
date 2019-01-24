package com.aip.servlet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


// пока не дорешал до конца использованее REST
// @Controller
public class TestViewController {

    @GetMapping("/test")
    @ResponseBody
    public String showTestPage() {
        return "test";
    }

    @GetMapping("/user")
    public String getUserPage() {
        return "user";
    }

}
