package com.aip.dao;

import com.aip.dao.model.Graphik;

public interface GraphikDao extends BaseDao<Long, Graphik> {

    Graphik findByGraphikId(Long id);
}
