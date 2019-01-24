package com.aip.dao;

import com.aip.dao.model.Auditor;

public interface AuditorDao extends BaseDao<Long, Auditor> {

    Auditor findByAuditorName(String name);


}
