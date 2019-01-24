package com.aip.dao.impl;

import com.aip.dao.BaseDaoImpl;
import com.aip.dao.ContractDao;
import com.aip.dao.model.Contract;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDaoImpl extends BaseDaoImpl<Long, Contract> implements ContractDao {

    private static final ContractDao INSTANCE = new ContractDaoImpl();

    public static ContractDao getInstance(){
        return INSTANCE;
    }

    @Override
    public Contract findByContractId(Long id) {
        return null;
    }
}
