package com.aip.dao;

import com.aip.dao.model.AnalyticCode;

import java.util.List;

public interface AnalyticCodeDao extends BaseDao<Long, AnalyticCode> {

    List<AnalyticCode> getAnalyticCodeDao();
}
