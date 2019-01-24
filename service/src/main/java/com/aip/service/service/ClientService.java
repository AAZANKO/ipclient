package com.aip.service.service;

import com.aip.dao.converter.ConverterClientAllDtoImpl;
import com.aip.dao.converter.ConverterImpl;
import com.aip.dao.dto.ClientAllDto;
import com.aip.dao.model.Client;
import com.aip.dao.model.Status;
import com.aip.dao.repository.ClientRepository;
import com.aip.service.dto.ClientServiceDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CacheConfig(cacheNames = "clients")
@Service
// @RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Transactional(readOnly = true) // только на чтение
public class ClientService {

    private Long id;
    private String name;
    private String shortName;

    private ClientRepository clientRepository;
    private SessionFactory sessionFactory;
    private ConverterImpl converter;
    private ConverterClientAllDtoImpl converterClientAllDto;

    @Autowired
    public ClientService(ClientRepository clientRepository, SessionFactory sessionFactory, ConverterImpl converter, ConverterClientAllDtoImpl converterClientAllDto) {
        this.clientRepository = clientRepository;
        this.sessionFactory = sessionFactory;
        this.converter = converter;
        this.converterClientAllDto = converterClientAllDto;
    }

//    @Autowired
//    private ClientRepository clientRepository;
//    @Autowired
//    private SessionFactory sessionFactory;
//    private ClientDao clientDao;

    @Transactional
    public Client addByClientNew(ClientServiceDto clientServiceDto) {

        System.out.println(clientServiceDto.getClientNumber() + " " +
                        clientServiceDto.getName() + " " +
                        clientServiceDto.getShortName() + " " +
                        clientServiceDto.getAnalyticType() + " " +
                        clientServiceDto.getAnalyticCode() + " " +
                        Instant.now() + " " +
                        "1990-01-01T00:00:00Z" + " " +
                        clientServiceDto.getUnp() + " " +
                        clientServiceDto.getAccount() + " " +
                        clientServiceDto.getLegalCity() + " " +
                        clientServiceDto.getLegalStreet() + " " +
                        clientServiceDto.getLegalHouse() + " " +
                        clientServiceDto.getTerritoryCity() + " " +
                        clientServiceDto.getTerritoryStreet() + " " +
                        clientServiceDto.getTerritoryHouse() + " " +
                        clientServiceDto.getDesignationType() + " " +
                        clientServiceDto.getDesignationCode() + " " +
                        clientServiceDto.getCountPerson() + " " +
                        Status.OPEN + " " + "1");
        return clientRepository.save(
                Client.builder()
                        .clientNumber(clientServiceDto.getClientNumber())
                        .name(clientServiceDto.getName())
                        .shortName(clientServiceDto.getShortName())
                        //.analyticType(Long.parseLong(clientServiceDto.getAnalyticType())) // нет таких палей переписан Client Model
                        //.analyticCode(Long.parseLong(clientServiceDto.getAnalyticCode())) // нет таких палей переписан Client Model
                        .dateOpen(Instant.now())
                        .dateClose(Instant.parse("1990-01-01T00:00:00Z"))
                        .unp(Integer.valueOf(clientServiceDto.getUnp()))
                        .account(clientServiceDto.getAccount())
                        //.legalCity(clientServiceDto.getLegalCity()) // нет таких палей переписан Client Model
                        //.legalStreet(clientServiceDto.getLegalStreet()) // нет таких палей переписан Client Model
                        //.legalHouse(clientServiceDto.getLegalHouse()) // нет таких палей переписан Client Model
                        //.territoryCity(clientServiceDto.getTerritoryCity()) // нет таких палей переписан Client Model
                        //.territoryStreet(clientServiceDto.getTerritoryStreet()) // нет таких палей переписан Client Model
                        //.territoryHouse(clientServiceDto.getTerritoryHouse()) // нет таких палей переписан Client Model
                        //.designationType(Integer.valueOf(clientServiceDto.getDesignationType())) // нет таких палей переписан Client Model
                        //.designationCode(Integer.valueOf(clientServiceDto.getDesignationCode())) // нет таких палей переписан Client Model
                        .countPerson(Integer.valueOf(clientServiceDto.getCountPerson()))
                        .status(Status.OPEN)
                        .officerId(1L)
                        .build());
    }

//    @Transactional
//    public Client addByClientNew(ClientServiceDto clientServiceDto){
//        Client client = new Client();
//        client.setClientNumber(clientServiceDto.getClientNumber());
//        client.setName(clientServiceDto.getName());
//        client.setShortName(clientServiceDto.getShortName());
//        client.setAnalyticType(Long.parseLong(clientServiceDto.getAnalyticType()));
//        client.setAnalyticCode(Long.parseLong(clientServiceDto.getAnalyticCode()));
//        client.setDateOpen(Instant.now());
//        client.setDateClose(Instant.parse("1990-01-01T00:00:00Z"));
//        client.setUnp(Integer.valueOf(clientServiceDto.getUnp());
//        client.setAccount(clientServiceDto.getAccount());
//        client.setLegalCity(clientServiceDto.getLegalCity());
//        client.setLegalStreet(clientServiceDto.getLegalStreet());
//        client.setLegalHouse(clientServiceDto.getLegalHouse());
//        client.setTerritoryCity(clientServiceDto.getTerritoryCity());
//        client.setTerritoryStreet(clientServiceDto.getTerritoryStreet());
//        client.setTerritoryHouse(clientServiceDto.getTerritoryHouse());
//        client.setDesignationType(Integer.valueOf(clientServiceDto.getDesignationType()));
//        client.setDesignationCode(Integer.valueOf(clientServiceDto.getDesignationCode()));
//        client.setCountPerson(Integer.valueOf(clientServiceDto.getCountPerson()));
//        client.setStatus(Status.OPEN);
//        //client.setOfficer(1L);
//        //client.setOfficer(Long.parseLong(clientServiceDto.getOfficer()));
//
//        return clientRepository.save(client);
//    }

    public Integer findByCountRows(){
        return clientRepository.findByCountRows();
    }

    public List<Client> findAllBy(int page, int size) {
        List<Client> allClient = clientRepository.findAllBy(PageRequest.of(page, size));
        return allClient;
    }

    public List<Client> findAllByQueryMethod() {
//        List<Client> allClient = clientRepository.findAllByQueryMethod();
//        List<Tuple> allClient = clientRepository.findAllByQueryMethod();
//        List<ClientDto> clientDaoList = allClient.stream().map(converter::convert).collect(Collectors.toList());
        return null;
    }

    public List<Client> findByShortName(String shortName) {
        this.shortName = shortName; // добавить валидацию
        List<Client> allClient = clientRepository.findByShortName(this.shortName);
        return allClient;
    }

    public List<Client> findByName(String name) {
        this.name = name; // добавить валидацию
        List<Client> allClient = clientRepository.findByName(this.name);
        return allClient;
    }

    // User user = repository.findById(userId).get();
    @Cacheable("clients")
    public Client findById(Long id) {
        this.id = id; // добавить валидацию
        //Client allClient = clientRepository.findById(this.id);
        Client allClient = clientRepository.findById(this.id).get(); // .get - потому что Optional
        // Client allClient = clientRepository.findById(this.id);
        return allClient;
    }


    // возвращает всех открытых клиентов с пагенацией
    public List<ClientAllDto> findAllByClientOpenDtoAnalytic(int page, int size){
        List<javax.persistence.Tuple> allClientAllDto = clientRepository.findAllByClientOpenDtoAnalytic(PageRequest.of(page, size));
        List<ClientAllDto> list = allClientAllDto.stream().map(converterClientAllDto::convert).collect(Collectors.toList());
        return list;
    }

//
//    @Transactional // откроется новыя на редактирование
//    public Client save(Client client) {
////        Client clientNew = new Client("200006", "ООО ИНКОФУД", "ИНКОФУД", 1L, 1L, Instant.now(), Instant.now(), 200187973, "BY23BSBB301212312345010040", "Витебск", "кросноармейская", "20", "Витебск", "кросноармейская", "20", 2, 3, 2000, Status.OPEN, 1L);
////        return clientRepository.save(clientNew);
////    }
//        return clientRepository.save(
//                Client.builder()
//                .clientNumber("200006")
//                .name("ООО ИНКОФУД")
//                .shortName("ООО ИНКОФУД")
//                .analyticType(1L)
//                .analyticCode(1L)
//                .dateOpen(Instant.now())
//                .dateClose(Instant.now())
//                .unp(200187973)
//                .account("BY67BSBB301220000600103400000")
//                .designationType(2)
//                .designationCode(1)
//                .countPerson(23345)
//                .status(Status.OPEN)
//                .legalCity("Витебск").legalStreet("кросноармейская").legalHouse("31Д")
//                .territoryCity("Витебск").territoryStreet("кросноармейская").territoryHouse("31Д")
//                .officerId(1L)
//                .build());
//    }

}
