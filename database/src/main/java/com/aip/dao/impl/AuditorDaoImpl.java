package com.aip.dao.impl;

import com.aip.dao.AuditorDao;
import com.aip.dao.BaseDaoImpl;
import com.aip.dao.model.Auditor;
import org.springframework.stereotype.Repository;

@Repository
public class AuditorDaoImpl extends BaseDaoImpl<Long, Auditor> implements AuditorDao {

    private static final AuditorDao INSTANCE = new AuditorDaoImpl();

    public static AuditorDao getInstance(){
        return INSTANCE;
    }

    @Override
    public Auditor findByAuditorName(String name) {
        return null;
    }
}
