package com.aip.dao;

import com.aip.dao.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseDao<P extends Serializable, E extends BaseEntity<P>> {

    P save(E entity);

    void update(E entity);

    void delete(E entity);

    Optional<E> find(P id);

    List<E> findAll();
}
