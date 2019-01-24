package com.aip.dao;

import com.aip.dao.model.GraphikAuditor;

public interface GraphikAuditorDao extends BaseDao<Long, GraphikAuditor> {

    GraphikAuditor findByGraphikAuditorId(Long id);
}
