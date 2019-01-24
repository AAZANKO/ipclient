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
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@OptimisticLocking(type = OptimisticLockType.VERSION)
@Table(name = "service", schema = "opday")
@Component
public class Service extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "shortname")
    private String shortName;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    @Column(name = "service_date_open")
    private Instant serviceDateOpen;

    @Column(name = "service_date_close")
    private Instant serviceDateClose;

    @OneToMany(mappedBy = "service")
    private Set<Contract> contractId = new HashSet<>();

    @Version
    @Column(name = "version")
    private Long version;

    public Service(String name, String shortName, Status status, Instant serviceDateOpen, Instant serviceDateClose) {
        this.name = name;
        this.shortName = shortName;
        this.status = status;
        this.serviceDateOpen = serviceDateOpen;
        this.serviceDateClose = serviceDateClose;
    }
}
