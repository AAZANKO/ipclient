package com.aip.dao;

import com.aip.dao.configuration.PersistenceConfig;
import com.aip.dao.converter.ConverterImpl;
import com.aip.dao.converter.ConverterImplSDClient;
import com.aip.dao.dto.ClientDto;
import com.aip.dao.dto.ClientDtoImpl;
import com.aip.dao.impl.ClientDaoImpl;
import com.aip.dao.model.Client;
import com.aip.dao.model.Officer;
import com.aip.dao.repository.ClientRepository;
import com.connection.ConnectionManager;
import com.querydsl.core.Tuple;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.stereotype.Repository;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrmDemo {

    public static void main(String[] args) {

//        // -------------   Поднятие контекста   --------------------------------------//
//        // LocalContainerEntityManagerFactoryBean // и тот и другой поднимают контекст
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class); // ОТКОМЕНТИТЬ
//
//        Instant instant = Instant.now();
//        System.out.println("Instant "+instant);
//
//
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println("LocalDateTime "+now);
//
//        now = LocalDateTime.of(1900,1,1,0,0,0);
//        System.out.println("LocalDateTime "+now);
//
//
//
//
//
//        // org.springframework.security.crypto.password.PasswordEncoder
//        // org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder()
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//
//
//        for (int i = 0; i < 5; i++) {
//            // "123456" - plain text - user input from user interface
//            String passwd = encoder.encode("123456");
//
//            // passwd - password from database
//            System.out.println(passwd); // print hash
//
//            // true for all 5 iteration
//            System.out.println(encoder.matches("123456", passwd));
//        }

//====================================================================================================================================================

//         LocalSessionFactoryBean // и тот и другой поднимают контекст
//         AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfigurationDao.class);
//
//         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//         ----------------------------------------------------------------------------//
//
//        System.out.println("=0=");
//        ClientRepositoryImpl clientRepository = context.getBean(ClientRepositoryImpl.class);
//        // ClientRepository clientRepository = context.getBean(ClientRepository.class);
//
//        // Optional<Client> client = clientRepository.checkFindByShortname("СПАРТАК");
//        Optional<Client> client = clientRepository.findByIdLong(1L);
//
//        System.out.println(client.get().getClientNumber());

//======================================================================================================
//        Long offiserId = 1L;
//
//        Client clientId = clientDaoImpl.findByClientId(offiserId);
//
//        Optional<Client> opClient = clientRepository.findById(1L); // поиск по ИД
//
//        System.out.println(clientId.getName()+" "+clientId.getShortName());
//======================================================================================================

        System.out.println("=1==============================================================================");

        // 1 ссылку на репозиторий
        ClientDaoImpl clientDaoImpl = context.getBean(ClientDaoImpl.class);
        ClientRepository clientRepository = context.getBean(ClientRepository.class);

       System.out.println("=2==============================================================================");

       // JPA Criteria

        List<Tuple> all = clientDaoImpl.otcherFindByClentAll();

        List<Long> orName = all.stream()
                .map(a -> a.get(0, Long.class))
                .collect(Collectors.toList());
        for (Long longbny : orName) {
            System.out.println(longbny);
        }

        System.out.println("=3==============================================================================");

        // ссылки не репозиторий -----------------------------------------
        //List<Client> allSpringData = clientRepository.findAllBy(PageRequest.of(0,10)); // поиск с пагенацией
        List<javax.persistence.Tuple> allSpringData = clientRepository.findAllByQueryMethod(); // через Tuple  / использовать конвертор persistence
        List<ClientDtoImpl> allSpringData2 = clientRepository.findAllByClientDtoImpl(); // через DTO - конвертировать не нужно / DTO - inerface

        // получаем конверторы из контекста ---------------------------------------------
        ConverterImpl converter = context.getBean(ConverterImpl.class);                     // querydsl
        ConverterImplSDClient converter2 = context.getBean(ConverterImplSDClient.class);    // persistence

        // конвертация из Tuple в ДТО
        List<ClientDto> list = all.stream().map(converter::convert).collect(Collectors.toList());                   // querydsl
        List<ClientDto> list21 = allSpringData.stream().map(converter2::convert).collect(Collectors.toList());      // persistence, spring data
        //List<ClientDtoImpl> list22 = allSpringData.stream().map(converter2::convert).collect(Collectors.toList()); // интерфейс н катит

//        На практике лучше вернуть пустой список примерно
//        List<ClientDto> list2 = Collections.emptyList();

        System.out.println("=4 querydsl TUPLE ==============================================================================");
        for (ClientDto listDto : list) {
            System.out.println(listDto.getId() + " " + listDto.getClientNumber() + " " + listDto.getName() + " " + listDto.getShortName());
        }

        System.out.println("=4 SpringData DTO ==============================================================================");
        for (ClientDtoImpl listDto : allSpringData2) {
            System.out.println(listDto.getId() + " " + listDto.getClientNumber() + " " + listDto.getName() + " " + listDto.getShortName());
        }

        System.out.println("=4 persistence TUPLE ==============================================================================");
        for (ClientDto listDto : list21) {
            System.out.println(listDto.getId() + " " + listDto.getClientNumber() + " " + listDto.getName() + " " + listDto.getShortName());
        }

        System.out.println("=5==============================================================================");




//        System.out.println("=3==============================================================================");
//
//        ConverterImpl converter = context.getBean(ConverterImpl.class);
//        ConverterImplSDClient converter2 = context.getBean(ConverterImplSDClient.class);
//
//        List<ClientDto> list = all.stream().map(converter::convert).collect(Collectors.toList());
//
//
//        List<ClientDto> list2 = allSpringData.stream().map(converter2::convert).collect(Collectors.toList());
//
//        System.out.println("=4==============================================================================");
//        for (ClientDto listDto : list2) {
//            System.out.println(listDto.getId() + " " + listDto.getClientNumber() + " " + listDto.getName() + " " + listDto.getShortName());
//        }
//
//        System.out.println("=4==============================================================================");
//        for (ClientDto listDto : list) {
//            System.out.println(listDto.getId() + " " + listDto.getClientNumber() + " " + listDto.getName() + " " + listDto.getShortName());
//        }
//
//        System.out.println("=5/1==============================================================================");
//
//        for (ClientDtoImpl listDto : list3) {
//            System.out.println(listDto.getId() + " " + listDto.getClientNumber() + " " + listDto.getName() + " " + listDto.getShortName());
//        }




////////////////////////////////////////////////////


        // List<Officer> list = session.createQuery("select o from Officer o", Officer.class).list();

//        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//
//                  Query<Officer> query = session.createQuery("select o from Officer o", Officer.class);
//            List<Officer> list = query.list();
//
//            for (Officer officer : list) {
//                System.out.println(officer.getId() + " " + officer.getFirstName() + " " + officer.getLastName() + " " +officer.getMiddleName());
//            }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //List<ClientOtcherDto> orNameList =  all.stream().map(clientOtcherDto.setIdClient()::convert).collect(toList);


//        for (Long client : orName) {
//            System.out.println(client);
//        }
//
//        List<String> orNameStr = all.stream().map(a -> a.get(1, String.class)).collect(Collectors.toList());
//
//
//        for (String client : orNameStr) {
//            System.out.println(client);
//        }
//
//        List<String> orNameStrDo = all.stream().map(a -> a.get(2, String.class)).collect(Collectors.toList());
//
//        for (String client : orNameStrDo) {
//            System.out.println(client);
//        }

//            Query<Client> query2 = session.createQuery("select c from Client c join fetch c.contract o where c.id = :officerId", Client.class)
//                    .setParameter("officerId", offiserId);
//            List<Client> list2 = query2.list();
//            for (Client client: list2) {
//                System.out.println(client.getId()+" "+client.getName()+" "+client.getUnp());
//            }
//
//
//            List<String> someList = new ArrayList<String>();
//
//            // add "monkey", "donkey", "skeleton key" to someList
//            for (String item : someList) {
//                 System.out.println(item);
//            }
//
//
//                             Query<Client> query3 = session.createQuery("select c from Client c join c.contract ct where c.id = :officerId", Client.class)
//                    .setParameter("officerId", offiserId);
//            List<Client> list3 = query3.list();
//
//
//                             session.getTransaction().commit();
//            // session.beginTransaction().rollback();
//            session.clear();
//            session.close();
//            sessionFactory.close();
//            ConnectionManager.getFACTORY().close();
//        } catch (Exception e) {
//            sessionFactory.close();
//            ConnectionManager.getFACTORY().close();
//            System.out.println("Exception e catch sessionFactory.close");
//            System.out.println(e);
//        }
                // sessionFactory.close();
            }
        }
