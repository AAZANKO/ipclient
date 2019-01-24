package com.aip.dao.impl;

import com.aip.dao.BaseDaoImpl;
import com.aip.dao.model.Graphik;
import com.aip.dao.GraphikDao;
import org.springframework.stereotype.Repository;

@Repository
public class GraphikDaoImpl extends BaseDaoImpl<Long, Graphik> implements com.aip.dao.GraphikDao {

    private static final com.aip.dao.GraphikDao INSTANCE = new GraphikDaoImpl();

    public static GraphikDao getInstance(){
        return INSTANCE;
    }

    @Override
    public Graphik findByGraphikId(Long id) {
        return null;
    }
}
