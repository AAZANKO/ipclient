package com.aip.service.service;

import com.aip.dao.converter.ConverterImplOfficerSecurity;
import com.aip.dao.dto.OfficerSecurityDto;
import com.aip.dao.repository.OfficerRepository;
import com.aip.service.converter.UserDetailsConverter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Tuple;
import java.net.URLEncoder;

@Service
@Transactional
@NoArgsConstructor
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private OfficerRepository officerRepository;
    private UserDetailsConverter userDetailsConverter;
    private ConverterImplOfficerSecurity converterImplOfficerSecurity;

    @Autowired
    public UserServiceImpl(OfficerRepository officerRepository, UserDetailsConverter userDetailsConverter, ConverterImplOfficerSecurity converterImplOfficerSecurity) {
        this.officerRepository = officerRepository;
        this.userDetailsConverter = userDetailsConverter;
        this.converterImplOfficerSecurity = converterImplOfficerSecurity;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Tuple findLoginSecurity = officerRepository.findByLoginSecurity(name);

        // bCryptPasswordEncoder.encode(); // так делать не нужно спринг сам все закодит
        OfficerSecurityDto byLogin = converterImplOfficerSecurity.convert(findLoginSecurity);

//        System.out.println("byLogin.getLogin() = "+byLogin.getLogin());
//        System.out.println("byLogin.getPassword() = "+byLogin.getPassword());

        UserDetails userDetails = userDetailsConverter.convert(byLogin);

//        System.out.println("userDetails.getUsername() = "+userDetails.getUsername());
//        System.out.println("userDetails.getPassword() = "+userDetails.getPassword());


        if (userDetails == null){
            throw new UsernameNotFoundException("User not found");
        }
        return userDetails;
    }




//    @Override
//    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
//        if (emailExist(accountDto.getEmail())) {
//            throw new EmailExistsException(
//                    "There is an account with that email adress:" + accountDto.getEmail());
//        }
//        User user = new User();
//        user.setFirstName(accountDto.getFirstName());
//        user.setLastName(accountDto.getLastName());
//
//        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
//
//        user.setEmail(accountDto.getEmail());
//        user.setRole(new Role(Integer.valueOf(1), user));
//        return repository.save(user);
//    }

}
