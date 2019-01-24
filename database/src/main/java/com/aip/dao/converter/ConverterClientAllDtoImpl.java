package com.aip.dao.converter;

import com.aip.dao.dto.ClientAllDto;
import javax.persistence.Tuple;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;

@Component
public class ConverterClientAllDtoImpl implements Converter<Tuple, ClientAllDto> {

    @Override
    public ClientAllDto convert(Tuple object) {
        return ClientAllDto.builder()
                .id(object.get(0, Number.class))
                .clientNumber(object.get(1, Integer.class))
                .shortName(object.get(2, String.class))
                .address(object.get(3, String.class))
                .unp(object.get(4, Integer.class))
                .dateOpen(object.get(5, String.class))
                .dateClose(object.get(6, String.class))
                .collEmployee(object.get(7, Integer.class))
                .analyticNameOne(object.get(8, String.class))
                .analyticNameTwo(object.get(9, String.class))
                .analyticNameThree(object.get(10, String.class))
                .analyticNameFour(object.get(11, String.class))
                .officerName(object.get(12, String.class))
                .build();
    }
}
