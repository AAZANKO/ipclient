package com.aip.dao;

import com.aip.dao.model.Person;

public interface PersonDao extends BaseDao<Long, Person> {

    Person findByPersonId(Long id);
}
