package com.aip.dao.impl;

import com.aip.dao.model.Client;
import com.aip.dao.model.Officer;
import com.aip.dao.model.Person;
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
public class PersonDao {

    private static final PersonDao INSTANCE = new PersonDao();


    // если откоментить в model/Client аннотацию @Builder то можно откоментить и здесь!!
//    public Person PersonDao() {
//        return Person.builder()
//                .id(12L)
//                .client(Client.builder().id(1L).build())
//                .firstName("Ivanov")
//                .lastName("Ivan")
//                .middleName("Ivanovich")
//                .officer(Officer.builder().id(1L).build())
//                .comment("comment")
//                .status(Status.OPEN)
//                .personTypeId(1L)
//                .personCodeId(1L)
//                .personOpenDate(Instant.now())
//                .personCloseDate(Instant.now())
//                .build();
//    }

    public static PersonDao getInstance() {
        return INSTANCE;
    }
}
