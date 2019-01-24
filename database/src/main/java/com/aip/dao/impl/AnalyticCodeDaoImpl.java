package com.aip.dao.impl;

import com.aip.dao.AnalyticCodeDao;
import com.aip.dao.BaseDaoImpl;
import com.aip.dao.model.AnalyticCode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnalyticCodeDaoImpl extends BaseDaoImpl<Long, AnalyticCode> implements AnalyticCodeDao {

    private static final AnalyticCodeDao INSTANCE = new AnalyticCodeDaoImpl();

    public static AnalyticCodeDao getInstance(){
        return INSTANCE;
    }

    @Override
    public List<AnalyticCode> getAnalyticCodeDao() {
        return findAll();
    }
}
