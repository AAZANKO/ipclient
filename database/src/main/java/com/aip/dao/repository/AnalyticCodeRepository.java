package com.aip.dao.repository;

import com.aip.dao.model.AnalyticCode;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AnalyticCodeRepository extends CrudRepository<AnalyticCode, Long> {

    Optional<AnalyticCode> findAllBy();
}
