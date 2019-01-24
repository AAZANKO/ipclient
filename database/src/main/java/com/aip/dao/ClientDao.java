package com.aip.dao;

import com.aip.dao.model.Client;
import com.querydsl.core.Tuple;

import java.util.List;

public interface ClientDao extends BaseDao<Long, Client> {

    Client findByClientId(Long id);

    List<Client> otcherClentAll();

    List<Client> otcherFindByClentName(String name);

    List<Tuple> otcherFindByClentAll();

    // List<Client> otcherFindByClentNameAndStatus(String name, Status status);
}
