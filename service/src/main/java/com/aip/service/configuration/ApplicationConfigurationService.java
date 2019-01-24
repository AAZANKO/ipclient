package com.aip.service.configuration;

import com.aip.dao.configuration.ApplicationConfigurationDao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.aip.service","com.aip.aspect"})
@Import(value = ApplicationConfigurationDao.class)
public class ApplicationConfigurationService {

}
