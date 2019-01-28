package com.aip.dao.repository;

import com.aip.dao.model.AnalyticCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AnalyticCodeRepository extends CrudRepository<AnalyticCode, Long> {

    Optional<AnalyticCode> findAllBy();

    @Query("select a from AnalyticCode a where a.analyticType = 2 and a.status = 1 order by a.name")
    List<AnalyticCode> findAnalyticCodeByRelationtype1();

    @Query("select a from AnalyticCode a where a.analyticType = 1 and a.status = 1 order by a.name")
    List<AnalyticCode> findAnalyticCodeByRelationtype2();

    @Query("select a from AnalyticCode a where a.analyticType = 3 and a.status = 1 order by a.name")
    List<AnalyticCode> findAnalyticCodeByRelationtype3();

    @Query("select a from AnalyticCode a where a.analyticType = 4 and a.status = 1 order by a.name")
    List<AnalyticCode> findAnalyticCodeByRelationtype4();
}
