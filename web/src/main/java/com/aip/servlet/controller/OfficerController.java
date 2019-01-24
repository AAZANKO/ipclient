package com.aip.servlet.controller;

import com.aip.dao.model.Officer;
import com.aip.service.service.OfficerService;
import com.aip.service.service.ServiceService;
import com.aip.service.dto.OfficerServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OfficerController {

//    @Autowired
//    private ServiceService serviceService; // на кой это тут нужно !?

    @Autowired
    private OfficerService officerService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @GetMapping("/addOfficer")
    public String getOfficerPage(Model model) {
        return "addOfficer";
    }


    @GetMapping
    public String getOfficerAll(Model model){
        List<Officer> findOfficerAll = officerService.findByAll(0, 10);
        model.addAttribute("findOfficerAll", findOfficerAll);
        return "home";
    }

//    @PostMapping("/addOfficer")
//    public String getOfficerPage(@ModelAttribute("officer") Officer officer) {
//        System.out.println(officer.getFirstName()+" "+officer.getLastName()+" "+officer.getMiddleName());
//        return "home";
//    }

    @PostMapping("/addOfficer")
    public String getOfficerPage(Model model
            , @RequestParam("firstName") String firstName
            , @RequestParam("lastName") String lastName
            , @RequestParam("middleName") String middleName
            , @RequestParam("officerType") String officerType
            , @RequestParam("officerCode") String officerCode
            , @RequestParam("datePrinyat") String datePrinyat
            , @RequestParam("dateUvolen") String dateUvolen
            , @RequestParam("status") String status
            , @RequestParam("login") String login
            , @RequestParam("password") String password
            , @RequestParam("role") String role) {
        OfficerServiceDto officerServiceDto = new OfficerServiceDto();
        officerServiceDto.setFirstName(firstName);
        officerServiceDto.setLastName(lastName);
        officerServiceDto.setMiddleName(middleName);
        officerServiceDto.setOfficerType(officerType);
        officerServiceDto.setOfficerCode(officerCode);
        officerServiceDto.setDatePrinyat(datePrinyat);
        officerServiceDto.setDateUvolen(dateUvolen);
        officerServiceDto.setStatus(status);
        officerServiceDto.setLogin(login);
        /* officerServiceDto.setPassword(passwordEncoder.encode(password)); */
        officerServiceDto.setPassword(password);
        officerServiceDto.setRole(role);

        Officer officer = officerService.addByOfficerNew(officerServiceDto);

        model.addAttribute("addofficers", officer);

        return "home";
    }


}
