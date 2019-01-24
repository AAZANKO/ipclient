package com.aip.dao.converter;

import com.aip.dao.dto.ClientDto;
import com.querydsl.core.Tuple;
import org.springframework.stereotype.Component;

import java.time.Instant;


@Component
public class ConverterImpl implements Converter<Tuple, ClientDto> {

    @Override
    public ClientDto convert(Tuple object) {
//        return ClientDto.builder()
//                .id(object.get(0, Long.class))
//                .clientNumber(object.get(1, String.class))
//                .name(object.get(2, String.class))
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

        return ClientDto.builder()
                .id(object.get(0, Long.class))
                .account(object.get(1, String.class))
                .clientNumber(object.get(2, Integer.class))
                .collEmployee(object.get(3, Integer.class))
                .dateclose(object.get(4, Instant.class))
                .dateopen(object.get(5, Instant.class))
                .address(object.get(6, String.class))
                .name(object.get(7, String.class))
                .shortName(object.get(8, String.class))
                .status(object.get(9, Integer.class))
                .unp(object.get(10, Integer.class))
                .version(object.get(11, Integer.class))
                .officerId(object.get(12, Long.class))
                //    private Long officer,
                .relationtype1(object.get(13, Long.class))
                .relationcode1(object.get(14, Long.class))
                .relationtype2(object.get(15, Long.class))
                .relationcode2(object.get(16, Long.class))
                .relationtype3(object.get(17, Long.class))
                .relationcode3(object.get(18, Long.class))
                .relationtype4(object.get(19, Long.class))
                .relationcode4(object.get(20, Long.class))
                .build();
    }

}
