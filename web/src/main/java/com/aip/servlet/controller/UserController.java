package com.aip.servlet.controller;

import org.springframework.http.MediaType;
import com.aip.servlet.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDto get(@PathVariable("id") Long id){
        return UserDto.builder()
                .firstName("wfeef")
                .lastName("fgerergreg")
                .middleName("ewfwefwef")
                .build();
    }

}
