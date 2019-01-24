package com.aip.dao.repository.impl;

import com.aip.dao.model.Client;
import com.aip.dao.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// @Transactional
@Repository
public class ClientRepositoryImpl { //implements ClientRepository{

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SessionFactory sessionFactory;

//    @Autowired // потому что есть аннотация
//    public ClientRepositoryImpl(){}

    public void checkFindAll() {
        clientRepository.findAll().forEach(System.out::println);
    }

    public List<Client> checkFindByShortname(String nameShortName) {
//        Optional<Client> client = clientRepository.findByShortName(nameShortName);
//        return client;
        return clientRepository.findByShortName(nameShortName);
    }

    public Optional<Client> findByIdLong(Long id) {
        return clientRepository.findById(id);
    }
}
