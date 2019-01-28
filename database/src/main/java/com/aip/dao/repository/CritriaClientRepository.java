package com.aip.dao.repository;

import com.aip.dao.dto.ClientAllDto;

import java.util.List;

public interface CritriaClientRepository {

    List<ClientAllDto> findByAllClientFilter(Integer relationtype1, Integer relationtype2, Integer relationtype3, Integer relationtype4);
}
