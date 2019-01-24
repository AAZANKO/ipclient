package com.aip.dao.impl;

import com.aip.dao.BaseDaoImpl;
import com.aip.dao.model.Person;
import com.aip.dao.PersonDao;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl extends BaseDaoImpl<Long, Person> implements com.aip.dao.PersonDao {

    private static final com.aip.dao.PersonDao INSTANCE = new PersonDaoImpl();

    public static PersonDao getInstance(){
        return INSTANCE;
    }

    @Override
    public Person findByPersonId(Long id) {
        return null;
    }
}
