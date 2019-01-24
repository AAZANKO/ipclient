package com.aip.dao.impl;

import com.aip.dao.BaseDaoImpl;
import com.aip.dao.model.Service;
import com.aip.dao.ServiceDao;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceDaoImpl extends BaseDaoImpl<Long, Service> implements ServiceDao{

    private static final ServiceDao INSTANCE = new ServiceDaoImpl();

    public static ServiceDao getInstance(){
        return INSTANCE;
    }

}
