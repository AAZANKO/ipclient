package com.aip.dao;

import com.aip.dao.model.Contract;

public interface ContractDao extends BaseDao<Long, Contract> {

    Contract findByContractId(Long id);
}
