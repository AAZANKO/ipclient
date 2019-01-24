package com.aip.dao.configuration;

import com.aip.dao.dto.ClientDto;
import com.aip.dao.impl.ClientDaoImpl;
import com.aip.dao.model.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.aip.dao")
public class BeanDaoConfiguration {

/*    @Bean
    public Client client(){
        return new Client();
    }*/

    @Bean
    public ClientDto clientDto(){
        return new ClientDto();
    }

    @Bean
    public ClientDaoImpl clientDaoImpl(){
        return new ClientDaoImpl();
    }

}
