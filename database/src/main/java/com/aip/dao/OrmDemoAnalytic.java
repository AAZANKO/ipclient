package com.aip.dao;

import com.aip.dao.configuration.PersistenceConfig;
import com.aip.dao.model.AnalyticCode;
import com.aip.dao.model.Client;
import com.aip.dao.repository.AnalyticCodeRepository;
import com.aip.dao.repository.ClientRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class OrmDemoAnalytic {

    public static void main(String[] args) {

        // -------------   Поднятие контекста   --------------------------------------//
        // LocalContainerEntityManagerFactoryBean // и тот и другой поднимают контекст
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class); // ОТКОМЕНТИТЬ

        AnalyticCode analyticCode = context.getBean(AnalyticCode.class);

        AnalyticCodeRepository analyticCodeRepository = context.getBean(AnalyticCodeRepository.class);

        ClientRepository clientRepository = context.getBean(ClientRepository.class);



        List<AnalyticCode> analyticCodeList = analyticCodeRepository.findAnalyticCodeByRelationtype1();

        for (AnalyticCode analyticCode1 : analyticCodeList) {
            System.out.println(analyticCode1.getId()+" "+analyticCode1.getName()+" "+analyticCode1.getShortName());
        }

        //======================================================================



    }
}
