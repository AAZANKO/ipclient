package com.aip.dao.impl;

import com.aip.dao.model.Auditor;
import com.aip.dao.model.Graphik;
import com.aip.dao.model.GraphikAuditor;
import com.aip.dao.model.Officer;
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
public class GraphikAuditorDao {

    private static final GraphikAuditorDao INSTANCE = new GraphikAuditorDao();

    public GraphikAuditor GraphikAuditorDao() {
        return GraphikAuditor.builder()
                .id(1L)
                .graphik(Graphik.builder().id(1L).build())
                .auditor(Auditor.builder().id(1L).build())
                .date(Instant.now())
                .comment("comment")
                .officer(Officer.builder().id(1L).build())
                .build();
    }

    public static GraphikAuditorDao getInstance() {
        return INSTANCE;
    }

}
