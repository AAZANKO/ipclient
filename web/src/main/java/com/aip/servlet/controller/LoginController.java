package com.aip.servlet.controller;

import com.aip.dao.model.Status;
import com.aip.servlet.dto.Gender;
import com.aip.servlet.dto.UserDto;
import com.aip.servlet.exception.DaoException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@Controller
@SessionAttributes("currentUser") // имя атрибута с которым мапленный им объект попадет в сессию
public class LoginController {
//
//    @Autowired
//    private LoginService loginService;


    // передает сообщение, объект, список объектов (правочник) на страницу что бы всегда был доступ
    @ModelAttribute
    public void message(Model model) {
        model.addAttribute("message", "Test message");
        // можно из БД доставать и класть в атрибут (cuntroller -> service -> dao -> bd)
        model.addAttribute("defaultGender", Gender.values()[0]);
    }

    @GetMapping("/login")
    public String getPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(UserDto userDto, Model model, HttpServletRequest request) {

        return "/login";
    }
}
