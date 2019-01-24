package com.aip.dao;

import com.aip.dao.model.Officer;

public interface OfficerDao extends BaseDao<Long, Officer> {

    Officer findByOffiserName(String firstName);

}
