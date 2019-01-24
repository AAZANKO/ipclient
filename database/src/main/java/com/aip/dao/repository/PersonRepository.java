package com.aip.dao.repository;

import com.aip.dao.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository  extends CrudRepository<Person, Long> {
}
