package com.aip.dao.converter;

import com.aip.dao.dto.ClientDto;
import org.springframework.stereotype.Component;

import javax.persistence.Tuple;

@Component
public class ConverterImplSDClient implements Converter<Tuple, ClientDto> {

    @Override
    public ClientDto convert(Tuple object) {
        return ClientDto.builder()
                .id(object.get(0, Long.class))
                .clientNumber(object.get(1, Integer.class))
                .name(object.get(2, String.class))
//                .shortName(object.get(3, String.class))
//                .analyticType(object.get(4, Long.class))
//                .analyticCode(object.get(5, Long.class))
//                .dateOpen(object.get(6, Instant.class))
//                .dateClose(object.get(7, Instant.class))
//                .unp(object.get(8, Integer.class))
//                .account(object.get(9, String.class))
//                .legalCity(object.get(10, String.class))
//                .legalStreet(object.get(11, String.class))
//                .legalHouse(object.get(12, String.class))
//                .territoryCity(object.get(13, String.class))
//                .territoryStreet(object.get(14, String.class))
//                .territoryHouse(object.get(15, String.class))
//                .designationType(object.get(16, Integer.class))
//                .designationCode(object.get(17, Integer.class))
//                .countPerson(object.get(18, Integer.class))
//                .status(object.get(19, String.class))
                //.officer(object.get(20, String.class))
                .build();
    }
}
