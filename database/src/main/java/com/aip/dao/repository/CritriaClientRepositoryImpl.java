package com.aip.dao.repository;

import com.aip.dao.dto.ClientAllDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CritriaClientRepositoryImpl implements CritriaClientRepository {

    private EntityManager em;

    @Override
    public List<ClientAllDto> findByAllClientFilter(Integer relationtype1, Integer relationtype2, Integer relationtype3, Integer relationtype4) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<ClientAllDto> cq = cb.createQuery(ClientAllDto.class);
        // Что возвращает критериа ?

        // интерфейс как и спринг датп

        // клас дто

        // тупле

        Root<ClientAllDto> root = cq.from(ClientAllDto.class);

        //root.join(String.valueOf(AnalyticCode.analytiCcde));

        cq.select(root).where(
//                    add(filter.get)
                cb.and(
                        cb.equal(root.get("relationtype1"),relationtype1),
                        cb.equal(root.get("relationtype2"),relationtype2),
                        cb.equal(root.get("relationtype3"),relationtype3),
                        cb.equal(root.get("relationtype3"),relationtype4)
                )
        ).orderBy(cb.asc(root.get("id")));

        return em.createQuery(cq).getResultList();
    }
}
