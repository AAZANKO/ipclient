package com.aip.dao;

import com.aip.dao.model.Likvidaciya;

public interface LikvidaciyaDao extends BaseDao<Long, Likvidaciya> {
    Likvidaciya findByLikvidaciyaId(Long id);
}
