package com.aip.dao.model;

import lombok.*;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@OptimisticLocking(type = OptimisticLockType.VERSION)
@Table(name = "graphik_auditor", schema = "opday")
@Component
public class GraphikAuditor extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "graphik_id")
    private Graphik graphik;

//    @Column(name = "graphik_id")
//    private Long graphikId;

    @ManyToOne
    @JoinColumn(name = "auditor_id")
    private Auditor auditor;
//    @Column(name = "auditor_id")
//    private Long auditorId;

    @Column(name = "date")
    private Instant date;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private Officer officer;
//    @Column(name = "officer_id")
//    private Long officerId;

    @Column(name = "status")
    private Status status;

    @Version
    @Column(name = "version")
    private Long version;


    public GraphikAuditor(Graphik graphik, Auditor auditor, Instant date, String comment, Officer officer, Status status) {
        this.graphik = graphik;
        this.auditor = auditor;
        this.date = date;
        this.comment = comment;
        this.officer = officer;
        this.status = status;
    }
}
