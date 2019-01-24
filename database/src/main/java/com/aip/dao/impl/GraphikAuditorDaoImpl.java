package com.aip.dao.impl;

import com.aip.dao.BaseDaoImpl;
import com.aip.dao.model.GraphikAuditor;
import com.aip.dao.GraphikAuditorDao;
import org.springframework.stereotype.Repository;

@Repository
public class GraphikAuditorDaoImpl extends BaseDaoImpl<Long, GraphikAuditor> implements GraphikAuditorDao {

    private static final GraphikAuditorDao INSTANCE = new GraphikAuditorDaoImpl();

    public static GraphikAuditorDao getInstance(){
        return INSTANCE;
    }

    @Override
    public GraphikAuditor findByGraphikAuditorId(Long id) {
        return null;
    }
}
