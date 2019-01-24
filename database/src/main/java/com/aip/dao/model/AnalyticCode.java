package com.aip.dao.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@Entity
@OptimisticLocking(type = OptimisticLockType.VERSION)
@Table(name = "analyticcode", schema = "opday")
@Component
public class AnalyticCode extends BaseEntity<Long> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Id
//    @EmbeddedId
//    private AnalyticCodeDetail analyticCodeDetail;

    @Column(name = "analytic_type")
    private Long analyticType;

    @Column(name = "analytic_code")
    private Long analyticCode;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "name")
    private String name;

    @Column(name = "comment")
    private String comment;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "isopen")
    private Status status;

    @Version
    @Column(name = "version")
    private Long version;

    public AnalyticCode(Long analyticType, Long analyticCode, String shortName, String name, String comment, Status status) {
        this.analyticType = analyticType;
        this.analyticCode = analyticCode;
        this.shortName = shortName;
        this.name = name;
        this.comment = comment;
        this.status = status;
    }

//    public AnalyticCode(AnalyticCodeDetail analyticCodeDetail, String shortName, String name, String comment, Status status) {
//        this.analyticCodeDetail = analyticCodeDetail;
//        this.shortName = shortName;
//        this.name = name;
//        this.comment = comment;
//        this.status = status;
//    }
}
