package com.aip.dao.impl;

import com.aip.dao.BaseDaoImpl;
import com.aip.dao.ClientDao;
import com.aip.dao.model.*;
import com.aip.dao.model.Client;
import com.aip.dao.model.QClient;
import com.aip.dao.model.QOfficer;
import com.connection.ConnectionManager;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@EqualsAndHashCode(callSuper=false)
@Data
@NoArgsConstructor
@AllArgsConstructor //(onConstructor = @__(@Autowired))
@Builder
@Repository
//@Transactional // spring
public class ClientDaoImpl extends BaseDaoImpl<Long, Client> implements ClientDao {

    @Autowired
    private SessionFactory sessionFactory;

/*    private static final ClientDao INSTANCE = new ClientDaoImpl();

    public static ClientDao getInstance() {
        return INSTANCE;
    }*/

    @Override
    public Client findByClientId(Long id) {
        return getSessionFactory().openSession().find(Client.class,1L);
    }

    @Override
    public List<Client> otcherClentAll() {

        // @Cleanup Session session = ConnectionManager.getSession();
        @Cleanup Session session = sessionFactory.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Client> query = cb.createQuery(Client.class);
        Root<Client> from = query.from(Client.class);
        query.select(from);
        List<Client> list = session.createQuery(query).list();
        return list;
    }

    @Override
    public List<Client> otcherFindByClentName(String name) {

        // @Cleanup Session session = ConnectionManager.getSession();
        @Cleanup Session session = sessionFactory.openSession();

        // берем у сесии объект кретериа билдер
        CriteriaBuilder cb = session.getCriteriaBuilder();

        // параметризуем объект кретериа тем объектом который будем возвращать
        // т.е. * в селект фром
        // это объект критерии
        CriteriaQuery<Client> query = cb.createQuery(Client.class);

        // получаем фром из селекта фром
        Root<Client> from = query.from(Client.class);

        // выполняем запрос в БД
        // передаем в запроо форм из которой будем получать наши кретерии
        query.select(from).where(cb.equal(from.get("shortName"), name));


        // передаем критерию в сессию дастать объекты критерии
        List<Client> list = session.createQuery(query).list();

        return list;
    }

    @Override
    public List<Tuple> otcherFindByClentAll() {
////        return null;
////         @Cleanup Session session = ConnectionManager.getSession();
////
//        @Cleanup Session session = sessionFactory.openSession();
////
/////*                .join(QClient.client.analytiсCode, analyticCode.analyticCodeDetail.analyticCode)
////                .on(QClient.client.analytiсType, analyticCode.analyticCodeDetail.analyticType)
////
////                .join(QClient.client.analytiсCode, QAnalyticCode.analyticCode.analyticCodeDetail.analyticCode)
////                .on(QClient.client.analytiсType, QAnalyticCode.analyticCode.analyticCodeDetail.analyticType)*/
////
//        return new JPAQuery<Tuple>(session)
//                //.select(QClient.client.id, QClient.client.clientNumber, QClient.client.name, QClient.client.shortName, QClient.client.dateOpen, QClient.client.dateClose, QClient.client.unp, QClient.client.account, QClient.client.legalCity, QClient.client.legalStreet, QClient.client.legalHouse, QClient.client.territoryCity, QClient.client.territoryStreet, QClient.client.territoryHouse, QClient.client.designationType, QClient.client.designationCode, QClient.client.countPerson, QClient.client.status, QOfficer.officer.firstName, QOfficer.officer.lastName, QOfficer.officer.middleName)
//                .select(QClient.client.id.as("id"), QClient.client.clientNumber.as("client_number"), QClient.client.name.as("name"), QClient.client.shortName.as("shortname"))
//                .from(QClient.client)
//                .join(QClient.client.officer, QOfficer.officer)
////                .join(QAnalyticCode.analyticCode.)
////                .on(QAnalyticCode.analyticCode.analyticCodeDetail.analyticType.eq(QClient.client.analyticType)
////                        .and(QAnalyticCode.analyticCode.analyticCodeDetail.analyticCode.eq(QClient.client.analyticCode)))
//                .fetch();
        return null; // ругалось из-за .join(QClient.client.officer, QOfficer.officer)
    }



/*    @Override
    public List<Client> otcherFindByClentNameAndStatus(String name, Status status) {

        @Cleanup Session session = ConnectionManager.getSession();
        // берем у сесии объект кретериа билдер
        CriteriaBuilder cb = session.getCriteriaBuilder();

        // параметризуем объект кретериа тем объектом который будем возвращать
        // т.е. * в селект фром
        // это объект критерии
        CriteriaQuery<Client> query = cb.createQuery(Client.class);

        // получаем фром из селекта фром
         Root<Client> from = query.from(Client.class);

        // выполняем запрос в БД
        // передаем в запроо форм из которой будем получать наши кретерии
*//*        query.select(from).where(
                cb.and(cb.equal(from.get("shortName"), name),
                        cb.equal(from.get("status"), status)
                )
        );*//*
        // с подключенным hibernate-jpamodelgen в pom
        query.select(from).where(
                cb.and(//cb.equal(from.get(Client.shortName), name),
                        cb.equal(from.get(Client.status), status),
                        cb.like(from.get(Client.shortName), name)
                )
        );

        // передаем критерию в сессию дастать объекты критерии
        List<Client> list = session.createQuery(query).list();

        return list;

    }*/
}
