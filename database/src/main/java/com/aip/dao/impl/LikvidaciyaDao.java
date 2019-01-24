package com.aip.dao.impl;

import com.aip.dao.model.Client;
import com.aip.dao.model.Likvidaciya;
import com.aip.dao.model.Officer;
import com.aip.dao.model.Status;
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
public class LikvidaciyaDao {

    private static final LikvidaciyaDao INSTANCE = new LikvidaciyaDao();

    // если откоментить в model/Client аннотацию @Builder то можно откоментить и здесь!!
//    public Likvidaciya LikvidaciyaDao() {
//        return Likvidaciya.builder()
//                .id(1L)
//                .number(34L)
//                .client(Client.builder().id(1L).build())
//                .dateOpen(Instant.now())
//                .dateClose(Instant.now())
//                .status(Status.OPEN)
//                .officer(Officer.builder().id(1L).build())
//                .build();
//    }

    public static LikvidaciyaDao getInstance() {
        return INSTANCE;
    }

}
