package com.aip.dao.repository;

import com.aip.dao.dto.ClientDtoImpl;
import com.aip.dao.model.Client;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findAllBy(Pageable pageable); // Pageable pageable - пегенация

    List<Client> findByName(String name);

    List<Client> findByShortName(String shortName);

    //@Cacheable("clients")
    Optional<Client> findById(Long id);

    @Query("select c.id, c.clientNumber, c.name, c.shortName from Client c")
    //@Query("select c from Client c")
    List<Tuple> findAllByQueryMethod();


    @Query("select c from Client c")
    List<ClientDtoImpl> findAllByClientDtoImpl();

    @Query(value = "select   c.* from opday.client c ", nativeQuery = true)
    List<Client> findAllByClientOpenDto();


   // " " +

    @Query(value = "select c.id, c.client_number, c.shortname, c.address, c.unp, " +
            " TO_CHAR(c.dateopen, 'DD/MM/YYYY') as dateopen, TO_CHAR(c.dateclose, 'DD/MM/YYYY') as dateclose, " +
            " c.coll_employee, a1.name as name1, a2.name as name2, a3.name as name3, a4.name as name4, o.first_name||' '||o.last_name||' '||o.middle_name as oname " +
            " from opday.client c " +
            " left join opday.analyticcode a1 on a1.analytic_type = 2 and a1.analytic_code = c.relationcode1 " +
            " left join opday.analyticcode a2 on a2.analytic_type = 1 and a2.analytic_code = c.relationcode2 " +
            " left join opday.analyticcode a3 on a3.analytic_type = 3 and a3.analytic_code = c.relationcode3 " +
            " left join opday.analyticcode a4 on a4.analytic_type = 4 and a4.analytic_code = c.relationcode4 " +
            " left join opday.officer o on o.id = c.officer_id " +
            " where c.status = 1 order by c.id ", nativeQuery = true)
    List<Tuple> findAllByClientOpenDtoAnalytic(Pageable pageable);

    @Query(value = "select c.id, c.client_number, c.shortname, c.address, c.unp, c.dateopen, c.dateclose, c.coll_employee, a1.name as name1, a2.name as name2, a3.name as name3, a4.name as name4 o.first_name||' '||o.last_name||' '||o.middle_name as oname from opday.client c " +
            " left join opday.analyticcode a1 on a1.analytic_type = 2 and a1.analytic_code = c.relationcode1 " +
            " left join opday.analyticcode a2 on a2.analytic_type = 1 and a2.analytic_code = c.relationcode2 " +
            " left join opday.analyticcode a3 on a3.analytic_type = 3 and a3.analytic_code = c.relationcode3 " +
            " left join opday.analyticcode a4 on a4.analytic_type = 4 and a4.analytic_code = c.relationcode4 " +
            " left join opday.officer o on o.id = c.officer_id " +
            " where c.status = 0 order by c.id ", nativeQuery = true)
    List<Tuple> findAllByClientCloseDtoAnalytic();

    @Query(value = "select count(client.id) as kolvo from opday.client", nativeQuery = true)
    Integer findByCountRows();

}
