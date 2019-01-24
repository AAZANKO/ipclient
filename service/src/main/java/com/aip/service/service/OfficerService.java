package com.aip.service.service;

import com.aip.dao.model.Officer;
import com.aip.dao.model.Status;
import com.aip.dao.repository.OfficerRepository;
import com.aip.service.dto.OfficerServiceDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class OfficerService {

    private SessionFactory sessionFactory;
    private OfficerRepository officerRepository;

    @Autowired
    public OfficerService(OfficerRepository officerRepository, SessionFactory sessionFactory) {
        this.officerRepository = officerRepository;
        this.sessionFactory = sessionFactory;
    }

    public Officer findByLogin(String login){
        return officerRepository.findByLogin(login);
    }

    public List<Officer> findByAll(int page, int size){ return officerRepository.findAllBy(PageRequest.of(page,size)); }

    public Officer addByOfficerNew(OfficerServiceDto officerServiceDto){
        Officer officer = new Officer();
        officer.setFirstName(officerServiceDto.getFirstName());
        officer.setLastName(officerServiceDto.getLastName());
        officer.setMiddleName(officerServiceDto.getMiddleName());
        officer.setOfficerType(Integer.valueOf(officerServiceDto.getOfficerType()));
        officer.setOfficerCode(Integer.valueOf(officerServiceDto.getOfficerCode()));
        officer.setDatePrinyat(LocalDateTime.now());
        officer.setDateUvolen(LocalDateTime.of(1900,1,1,0,0,0));
        officer.setStatus(Status.OPEN);
        officer.setLogin(officerServiceDto.getLogin());
        officer.setPassword(officerServiceDto.getPassword());
        officer.setPassword(officerServiceDto.getPassword());
        officer.setRole(officerServiceDto.getRole());


        // нужен конвертор из DTO в Officer - елси не удасться на контреллере сохранить Officer ?????????
        return officerRepository.save(officer);
        // return officer;
    }
}
