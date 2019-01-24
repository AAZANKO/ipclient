package com.aip.dao.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@OptimisticLocking(type = OptimisticLockType.VERSION)
@Table(name = "anketa", schema = "opday")
@Component
public class Anketa extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;
//    @Column(name = "contract_id")
//    private Long contractId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
//    @Column(name = "client_id")
//    private Long clientId;

    @Column(name = "anketatype")
    private Integer anketaType;

    @Column(name = "anketacode")
    private Integer anketaCode;

    @Column(name = "dateopen")
    private Instant dateOpen;

    @Column(name = "dateclose")
    private Instant dateClose;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "officer_id")
    private Officer officer;
//    @Column(name = "officer_id")
//    private Long officerId;

    @Version
    @Column(name = "version")
    private Long version;

    public Anketa(Contract contract, Client client, Integer anketaType, Integer anketaCode, Instant dateOpen, Instant dateClose, Status status, Officer officer) {
        this.contract = contract;
        this.client = client;
        this.anketaType = anketaType;
        this.anketaCode = anketaCode;
        this.dateOpen = dateOpen;
        this.dateClose = dateClose;
        this.status = status;
        this.officer = officer;
    }

}
