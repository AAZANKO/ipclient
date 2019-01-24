package com.aip.dao.repository;

import com.aip.dao.model.Officer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.util.List;

public interface OfficerRepository  extends CrudRepository<Officer, Long> {

    Officer findByLogin(String login);

    List<Officer> findAllBy(Pageable pageable);

    @Query("select o.login, o.password, o.role from Officer o where upper(o.login) = upper(:login)")
    Tuple findByLoginSecurity(@Param("login") String login);
}
