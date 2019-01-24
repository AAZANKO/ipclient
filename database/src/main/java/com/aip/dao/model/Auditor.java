package com.aip.dao.model;

import lombok.*;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@OptimisticLocking(type = OptimisticLockType.VERSION)
@Table(name = "auditor", schema = "opday")
@Component
public class Auditor extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "auditortype")
    private Integer auditorType;

    @Column(name = "auditorcode")
    private Integer auditorCode;

    @Column(name = "date_prinyat")
    private Instant datePrinyat;

    @Column(name = "date_uvolen")
    private Instant dateUvolen;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    @Version
    @Column(name = "version")
    private Long version;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private Officer officer;
    //    @Column(name = "officer_id")
    //    private Long officerId;

    @OneToOne(mappedBy = "inspector")
    private Graphik graphik;

    @OneToMany(mappedBy = "auditor")
    private Set<GraphikAuditor> graphikAuditorId = new HashSet<>();

    public Auditor(String firstName, String lastName, String middleName, Integer auditorType, Integer auditorCode, Instant datePrinyat, Instant dateUvolen, Status status, Officer officer) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.auditorType = auditorType;
        this.auditorCode = auditorCode;
        this.datePrinyat = datePrinyat;
        this.dateUvolen = dateUvolen;
        this.status = status;
        this.officer = officer;
    }
}
