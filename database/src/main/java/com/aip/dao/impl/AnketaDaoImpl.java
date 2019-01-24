package com.aip.dao.impl;

import com.aip.dao.AnketaDao;
import com.aip.dao.BaseDaoImpl;
import com.aip.dao.model.Anketa;
import org.springframework.stereotype.Repository;

@Repository
public class AnketaDaoImpl extends BaseDaoImpl<Long, Anketa> implements AnketaDao {

    private static final AnketaDao INSTANCE = new AnketaDaoImpl();

    public static AnketaDao getInstance(){
        return INSTANCE;
    }

    @Override
    public Anketa findByAnketaId(Long id) {
        return null;
    }
}
