package com.aip.servlet.controller;

import com.aip.dao.dto.AnalyticCodeDto;
import com.aip.service.service.AnalyticCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AnalyticCodeController {

    @Autowired
    private AnalyticCodeService analyticCodeService;

    @GetMapping("/findAnalyticCodeByRelationtype1")
    public String FindAnalyticCodeByRelationType(Model model) {
        List<AnalyticCodeDto> analyticCodeDtoType1 = analyticCodeService.FindAnalyticCodeByRelationtype1();
//        for (AnalyticCodeDto analyticCodeDtoIn : analyticCodeDto) {
//            System.out.println(analyticCodeDtoIn.getCode() + " " + analyticCodeDtoIn.getName());
//        }
        List<AnalyticCodeDto> analyticCodeDtoType2 = analyticCodeService.FindAnalyticCodeByRelationtype2();
        List<AnalyticCodeDto> analyticCodeDtoType3 = analyticCodeService.FindAnalyticCodeByRelationtype3();
        List<AnalyticCodeDto> analyticCodeDtoType4 = analyticCodeService.FindAnalyticCodeByRelationtype4();

        model.addAttribute("analyticCodeType1", analyticCodeDtoType1);
        model.addAttribute("analyticCodeType2", analyticCodeDtoType2);
        model.addAttribute("analyticCodeType3", analyticCodeDtoType3);
        model.addAttribute("analyticCodeType4", analyticCodeDtoType4);

        return "findClient";
    }
}
