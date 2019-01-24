package com.aip.dao.impl;

import com.aip.dao.BaseDaoImpl;
import com.aip.dao.OfficerDao;
import com.aip.dao.model.Officer;
import org.springframework.stereotype.Repository;

@Repository
public class OfficerDaoImpl extends BaseDaoImpl<Long, Officer> implements OfficerDao {

    private static final OfficerDao INSTANCE = new OfficerDaoImpl();

    public static OfficerDao getInstance(){
        return INSTANCE;
    }

    @Override
    public Officer findByOffiserName(String firstName) {
        return null;
    }

//    @Override
//    public Class getEntityClazz() {
//        return Officer.class;
//    }
}
