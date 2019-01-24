package com.aip.service.converter;

import com.aip.dao.dto.OfficerSecurityDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsConverter implements Converter<OfficerSecurityDto, UserDetails> {

    @Override
    public UserDetails convert(OfficerSecurityDto officer) {
        return User.builder()
                .username(officer.getLogin())
                .password("{noop}" + officer.getPassword())
                .authorities(officer.getRole())
                .build();
    }
}
