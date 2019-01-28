package com.aip.dao;

import com.aip.dao.configuration.PersistenceConfig;
import com.aip.dao.converter.ConverterClientAllDtoImpl;
import com.aip.dao.dto.ClientAllDto;
import com.aip.dao.model.Client;
import com.aip.dao.repository.ClientRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.stream.Collectors;

public class OrmDemoClientAll {

    public static void main(String[] args) {


        int page = 0;
        int size = 20;

        // -------------   Поднятие контекста   --------------------------------------//
        // LocalContainerEntityManagerFactoryBean // и тот и другой поднимают контекст
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class); // ОТКОМЕНТИТЬ

        Client client = context.getBean(Client.class);

        ClientRepository clientRepository = context.getBean(ClientRepository.class);

        List<Client> allByClientOpenDto = clientRepository.findAllByClientOpenDto();

        for (Client clients:allByClientOpenDto) {
            System.out.println(clients.getId()+" "+clients.getName()+" "+clients.getShortName());
        }

        //======================================================================

        List<Client> allClient = clientRepository.findAllBy(PageRequest.of(page, size));

        for (Client client1:allClient) {
            System.out.println(client1.getName());
        }

        //====================================

        ConverterClientAllDtoImpl converterClientAllDtoImplconv = context.getBean(ConverterClientAllDtoImpl.class);

        List<javax.persistence.Tuple> allClientAllDto = clientRepository.findAllByClientOpenDtoAnalytic(PageRequest.of(page, size));

//        List<javax.persistence.Tuple> allClientAllDto = clientRepository.findAllByClientOpenDtoAnalyticFilter(PageRequest.of(page, size),3L,3L,1L,16L);

        Integer colRowes = clientRepository.findByCountRows();

        System.out.println("Количество строк в таблице Clients= " + colRowes);

        List<ClientAllDto> list = allClientAllDto.stream().map(converterClientAllDtoImplconv::convert).collect(Collectors.toList());

        for (ClientAllDto listDto : list) {
            // System.out.println(listDto.getClientNumber() + " " + listDto.getShortName() + " " + listDto.getAddress() + " " + listDto.getUnp()+" "+listDto.getAnalyticNameOne()+" "+listDto.getAnalyticNameTwo()+" "+listDto.getAnalyticNameThree()+ " "+listDto.getAnalyticNameFour()+" "+listDto.getOfficerName());
            System.out.println(listDto.getId());
        }

    }
}

