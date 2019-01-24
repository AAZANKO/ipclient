package com.aip.dao;

import com.aip.dao.configuration.PersistenceConfig;
import com.aip.dao.model.AnalyticCode;
import com.aip.dao.model.AnalyticCodeDetail;
import com.aip.dao.model.Status;
import com.aip.dao.repository.AnalyticCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class OrmDemoAnalyticDeteil {

    public static void main(String[] args) {



        // -------------   Поднятие контекста   --------------------------------------//
        // LocalContainerEntityManagerFactoryBean // и тот и другой поднимают контекст
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PersistenceConfig.class); // ОТКОМЕНТИТЬ


        AnalyticCode analyticCode = context.getBean(AnalyticCode.class);
        AnalyticCodeRepository analyticCodeRepository = context.getBean(AnalyticCodeRepository.class);

        // analyticCodeRepository.save(AnalyticCode.of(AnalyticCodeDetail.of(4L,4L),4L,4L,"Новый тип тест","Тест"," ", Status.OPEN,0L));

        analyticCodeRepository.save(AnalyticCode.builder().analyticType(4L).analyticCode(4L).shortName("Тест").name("Тест тест").comment(" ").status(Status.OPEN).build());

    }

}
