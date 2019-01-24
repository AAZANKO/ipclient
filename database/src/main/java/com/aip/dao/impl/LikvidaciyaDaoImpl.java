package com.aip.dao.impl;

import com.aip.dao.BaseDaoImpl;
import com.aip.dao.model.Likvidaciya;
import com.aip.dao.LikvidaciyaDao;
import org.springframework.stereotype.Repository;

@Repository
public class LikvidaciyaDaoImpl extends BaseDaoImpl<Long, Likvidaciya> implements LikvidaciyaDao {

    private static final LikvidaciyaDao INSTANCE = new LikvidaciyaDaoImpl();

    public static LikvidaciyaDao getInstance(){
        return INSTANCE;
    }

    @Override
    public Likvidaciya findByLikvidaciyaId(Long id) {
        return null;
    }
}
