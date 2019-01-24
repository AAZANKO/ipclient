package com.aip.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // с помощью чего поднять Spring context с помощью SpringRunner
//@ContextConfiguration(classes = ApplicationConfigurationDao.class) // с помощью именно какого контекста будем поднимать тест (class)
@ContextConfiguration(value = "classpath:application-context-test.xml") // с помощью именно какого контекста будем поднимать тест (xml)
@Transactional // org.spring  по умолчанию Rollback
public class ClientDaoTest {

    @Autowired
    private ClientDao clientDao;


    @Test
    public void checkContext() {
        assertNotNull(clientDao);
    }
}