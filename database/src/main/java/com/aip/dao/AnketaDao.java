package com.aip.dao;

import com.aip.dao.model.Anketa;

public interface AnketaDao extends BaseDao<Long, Anketa> {

    Anketa findByAnketaId(Long id);
}
