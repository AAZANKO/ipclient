package com.aip.dao.repository;

import com.aip.dao.model.Anketa;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AnketaRepository extends CrudRepository<Anketa, Long> {

    Optional<Anketa> findAllBy();
}
