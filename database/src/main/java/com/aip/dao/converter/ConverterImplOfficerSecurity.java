package com.aip.dao.converter;

import com.aip.dao.dto.OfficerSecurityDto;
import org.springframework.stereotype.Component;

import javax.persistence.Tuple;

@Component
public class ConverterImplOfficerSecurity implements Converter<Tuple, OfficerSecurityDto> {

    @Override
    public OfficerSecurityDto convert(Tuple object) {
        return OfficerSecurityDto.builder()
                .login(object.get(0, String.class))
                .password(object.get(1, String.class))
                .role(object.get(2, String.class))
                .build();
    }
}
