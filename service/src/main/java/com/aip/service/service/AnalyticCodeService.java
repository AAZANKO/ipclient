package com.aip.service.service;

import com.aip.dao.dto.AnalyticCodeDto;
import com.aip.dao.model.AnalyticCode;
import com.aip.dao.repository.AnalyticCodeRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class AnalyticCodeService {

    private AnalyticCodeRepository analyticCodeRepository;
    private SessionFactory sessionFactory;

    @Autowired
    public AnalyticCodeService(AnalyticCodeRepository analyticCodeRepository, SessionFactory sessionFactory){
        this.analyticCodeRepository = analyticCodeRepository;
        this.sessionFactory = sessionFactory;
    }


    public List<AnalyticCodeDto> FindAnalyticCodeByRelationtype1(){
        List<AnalyticCode> analyticCodeListType1 = analyticCodeRepository.findAnalyticCodeByRelationtype1();
        List<AnalyticCodeDto> analyticCodeListDtoType1 = new ArrayList<>();

        for (AnalyticCode analyticCode : analyticCodeListType1) {
            AnalyticCodeDto analyticCodeDtoType1 = new AnalyticCodeDto();
            analyticCodeDtoType1.setCode(analyticCode.getAnalyticCode());
            analyticCodeDtoType1.setName(analyticCode.getName());
            analyticCodeListDtoType1.add(analyticCodeDtoType1);
        }
        return analyticCodeListDtoType1;
    }


    public List<AnalyticCodeDto> FindAnalyticCodeByRelationtype2(){
        List<AnalyticCode> analyticCodeListType2 = analyticCodeRepository.findAnalyticCodeByRelationtype2();
        List<AnalyticCodeDto> analyticCodeListDtoType2 = new ArrayList<>();

        for (AnalyticCode analyticCode : analyticCodeListType2) {
            AnalyticCodeDto analyticCodeDtoType2 = new AnalyticCodeDto();
            analyticCodeDtoType2.setCode(analyticCode.getAnalyticCode());
            analyticCodeDtoType2.setName(analyticCode.getName());
            analyticCodeListDtoType2.add(analyticCodeDtoType2);
        }
        return analyticCodeListDtoType2;
    }


    public List<AnalyticCodeDto> FindAnalyticCodeByRelationtype3(){
        List<AnalyticCode> analyticCodeListType3 = analyticCodeRepository.findAnalyticCodeByRelationtype3();
        List<AnalyticCodeDto> analyticCodeListDtoType3 = new ArrayList<>();

        for (AnalyticCode analyticCode : analyticCodeListType3) {
            AnalyticCodeDto analyticCodeDto = new AnalyticCodeDto();
            analyticCodeDto.setCode(analyticCode.getAnalyticCode());
            analyticCodeDto.setName(analyticCode.getName());
            analyticCodeListDtoType3.add(analyticCodeDto);
        }
        return analyticCodeListDtoType3;
    }

    public List<AnalyticCodeDto> FindAnalyticCodeByRelationtype4(){
        List<AnalyticCode> analyticCodeListType4 = analyticCodeRepository.findAnalyticCodeByRelationtype4();
        List<AnalyticCodeDto> analyticCodeListDtoType4 = new ArrayList<>();

        for (AnalyticCode analyticCode : analyticCodeListType4) {
            AnalyticCodeDto analyticCodeDto = new AnalyticCodeDto();
            analyticCodeDto.setCode(analyticCode.getAnalyticCode());
            analyticCodeDto.setName(analyticCode.getName());
            analyticCodeListDtoType4.add(analyticCodeDto);
        }
        return analyticCodeListDtoType4;
    }

}
