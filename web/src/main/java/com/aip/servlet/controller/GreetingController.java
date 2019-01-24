package com.aip.servlet.controller;

import com.aip.servlet.dto.Address;
import com.aip.servlet.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

//    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    @GetMapping("/greeting/{id}")
    public String greeting(Model model,
                           @CookieValue("JSESSIONID") String jsessionId,
                           @RequestHeader("Accept") String header,
                           @RequestParam("id") String paramId,
                           @PathVariable("id") String pathId) {
        System.out.println("JSESSIONID: " + jsessionId);
        System.out.println("Accept: " + header);
        System.out.println("Param id: " + paramId);
        System.out.println("Path id: " + pathId);
//        model.addAttribute("currentUser", UserDto.of("Ivan", "123"));
        return "greeting";
    }

    @GetMapping("/test")
    public String test(@ModelAttribute("user") UserDto userDto,
                       @ModelAttribute("address") Address address) {
        System.out.println(userDto);
        return "greeting";
    }
}
