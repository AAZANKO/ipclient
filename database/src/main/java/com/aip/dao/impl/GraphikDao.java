package com.aip.dao.impl;

import com.aip.dao.model.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Data
@NoArgsConstructor
// @AllArgsConstructor
@Builder
@Repository
public class GraphikDao {

    private static final GraphikDao INSTANCE = new GraphikDao();

    // если откоментить в model/Client аннотацию @Builder то можно откоментить и здесь!!
//    public Graphik getGraphikDao() {
//        return Graphik.builder()
//                .id(1L)
//                .contract(Contract.builder().id(1L).build())
//                .client(Client.builder().id(1L).build())
//                .dateBegin(Instant.now())
//                .dateEnd(Instant.now())
//                .satage(2)
//                .inspector(Auditor.builder().id(1L).build())
//                .status(Status.CLOSED)
//                .officer(Officer.builder().id(1L).build())
//                .build();
//    }

    public static GraphikDao getInstance() {
        return INSTANCE;
    }
}
