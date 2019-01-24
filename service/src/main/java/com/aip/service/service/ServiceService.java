package com.aip.service.service;

import com.aip.dao.model.Officer;
import com.aip.dao.model.Status;
import com.aip.dao.repository.OfficerRepository;
import com.aip.service.dto.OfficerServiceDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
public class ServiceService {

    private OfficerRepository officerRepository;

    private SessionFactory sessionFactory;

//    private OfficerServiceDto officerServiceDto;
//
//    private Officer officer;


    @Autowired
    private ServiceService(OfficerRepository officerRepository, SessionFactory sessionFactory) {
        this.officerRepository = officerRepository;
        this.sessionFactory = sessionFactory;
    }

//        private Instant datePrinyat;
//        private Instant dateUvolen;
//        private Status status ;
//        private Long version;
//        private String login;
//        private String password;
//        private String role;

//    public Officer saveOfficer(OfficerServiceDto officerServiceDto) {
//
//        officer.setFirstName(officerServiceDto.getFirstName());
//        officer.setLastName(officerServiceDto.getLastName());
//        officer.setMiddleName(officerServiceDto.getMiddleName());
//        officer.setOfficerType(Integer.valueOf(officerServiceDto.getOfficerType()));
//        officer.setOfficerCode(Integer.valueOf(officerServiceDto.getOfficerCode()));
//        officer.setDatePrinyat(Instant.now());
//        officer.setDateUvolen(Instant.now());
//        officer.setStatus(Status.OPEN);
//        officer.setLogin(officerServiceDto.getLogin());
//        officer.setPassword(officerServiceDto.getPassword());
//        officer.setRole(officerServiceDto.getRole());
//
//        return officerRepository.save(officer);
//    }

}
