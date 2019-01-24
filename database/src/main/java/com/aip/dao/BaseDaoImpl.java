package com.aip.dao;

import com.aip.dao.model.BaseEntity;
import com.connection.ConnectionManager;
import lombok.Cleanup;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Getter
@Repository
public abstract class BaseDaoImpl<P extends Serializable, E extends BaseEntity<P>> implements BaseDao<P, E> {

    private Class<E> clazz;

    @Autowired
    private SessionFactory sessionFactory; //= new Configuration().configure().buildSessionFactory();

    @SuppressWarnings({"ConstantConditions", "unchecked"})
    public BaseDaoImpl() {
        // ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        // this.clazz = (Class<E>) type.getActualTypeArguments()[1];
        this.clazz = (Class<E>) GenericTypeResolver.resolveTypeArguments(getClass(), BaseDaoImpl.class)[1];
    }

    @SuppressWarnings("unchecked")
    @Override
    public P save(E entity) {
        // @Cleanup Session session = ConnectionManager.getSession();
        // @Cleanup Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        return (P) session.save(entity);
    }

    @Override
    public void update(E entity) {
        // @Cleanup Session session = ConnectionManager.getSession();
        // @Cleanup Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }

    @Override
    public void delete(E entity) {
        // @Cleanup Session session = ConnectionManager.getSession();
        // @Cleanup Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        session.delete(entity);
    }

    @Override
    public Optional<E> find(P id) {
        // @Cleanup Session session = ConnectionManager.getSession();
        // @Cleanup Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.find(clazz, id));
    }

    @Override
    public List<E> findAll() {
        // @Cleanup Session session = ConnectionManager.getSession();
        // @Cleanup Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> criteria = cb.createQuery(clazz);
        CriteriaQuery<E> select = criteria.select(criteria.from(clazz));
        // List<E> listQuery = session.createQuery(select).list();
        return session.createQuery(select).list();

//        @Cleanup Session session = ConnectionManager.getSession();
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<E> criteria = cb.createQuery(clazz);
//        criteria.select(criteria.from(clazz));
//        return session.createQuery(criteria).list();

        // List<E> list = session.createQuery(format("select e from E e", clazz.getSimpleName()), clazz).list();
        // return session.createQuery(format("select e from E e", clazz.getSimpleName()), clazz).list();
    }

    // public abstract Class<E> getEntityClazz();
}
