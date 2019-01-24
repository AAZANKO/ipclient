package com.aip.dao.impl;

import com.aip.dao.model.AnalyticCodeDetail;
import com.aip.dao.model.AnalyticCode;
import com.aip.dao.model.Status;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
// @AllArgsConstructor
@Builder
@Repository
public class AnalyticCodeDao {

    private static final AnalyticCodeDao INSTANCE = new AnalyticCodeDao();

//    public AnalyticCode getAnalyticCodeDao() {
//        return AnalyticCode.builder()
//                .analyticCodeDetail(AnalyticCodeDetail.of(1L, 1L))
//                .shortName("det")
//                .name("deteil")
//                .comment("comment")
//                .status(Status.OPEN)
//                .build();
//    }

    public static AnalyticCodeDao getInstance() {
        return INSTANCE;
    }

}
