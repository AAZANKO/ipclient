package com.aip.dao.impl;

import com.aip.dao.configuration.ApplicationConfigurationDao;
import com.aip.dao.model.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // с помощью чего поднять Spring context с помощью SpringRunner
// @ContextConfiguration(classes = ApplicationConfigurationDao.class) // с помощью именно какого контекста будем поднимать тест (class)
@ContextConfiguration(value = "classpath:application-context-test.xml") // с помощью именно какого контекста будем поднимать тест (xml)
// @ContextConfiguration(classes = ApplicationConfigurationDao.class) // настроена реалка
@Transactional // org.spring  по умолчанию Rollback
public class ClientDaoImplTest {

    @Autowired
    private ClientDaoImpl clientDaoImpl;

    @Test
    public void checkContext() {
        assertNotNull(clientDaoImpl);
    }

/*    @Value("${db.username}")
    private String username;

    @Value("#{'${numbers}'.split(',')}")
    private List<Integer> numbers;

    @Value("classpath:database.properties")
    private Resource resource;
    */

/*    @Test
    public void checkSaveEmployee() {
        Long savedId = clientDaoImpl.save(Client.of("Ivan", Gender.MALE));
        assertNotNull(savedId);

        Optional<Employee> employee = employeeDao.find(savedId);
        assertTrue(employee.isPresent());
    }*/

}