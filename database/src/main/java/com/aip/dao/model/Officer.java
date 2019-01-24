package com.aip.dao.model;

import lombok.*;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
//@EqualsAndHashCode(of = "id")
@Builder
@Entity
@OptimisticLocking(type = OptimisticLockType.VERSION)
@Table(name = "officer", schema = "opday")
//@Inheritance(strategy = InheritanceType.JOINED)
@Component
public class Officer extends BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "officertype")
    private Integer officerType;

    @Column(name = "officercode")
    private Integer officerCode;

    @Column(name = "date_prinyat")
    private LocalDateTime datePrinyat;

    @Column(name = "date_uvolen")
    private LocalDateTime dateUvolen;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status ;

    @Version
    @Column(name = "version")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long version;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "address")
    private String address;

    @Column(name = "comment")
    private String comment;

    @Column(name = "e_mail")
    private String eMail;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "officer")
    private Set<Anketa> anketaId = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<Auditor> auditorId = new HashSet<>();

//    @OneToMany(mappedBy = "officer")
//    private Set<Client> clientId = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<Contract> contractId = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<Graphik> graphikId = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<Graphik> graphikIdInspector = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<GraphikAuditor> graphikAuditorId = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<Likvidaciya> likvidaciyaId = new HashSet<>();

    @OneToMany(mappedBy = "officer")
    private Set<Person> personId = new HashSet<>();

        public Officer(String firstName, String lastName, String middleName, Integer officerType, Integer officerCode, LocalDateTime datePrinyat, LocalDateTime dateUvolen, Status status, String login, String password, String role, String address, String comment, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.officerType = officerType;
        this.officerCode = officerCode;
        this.datePrinyat = datePrinyat;
        this.dateUvolen = dateUvolen;
        this.status = status;
        this.login = login;
        this.password = password;
        this.role = role;
        this.address = address;
        this.comment = comment;
        this.phone = phone;
    }

    //    @OneToMany(mappedBy = "officer")
    //    private Set<Service> serviceId = new HashSet<>();

//    @Autowired
//    public Officer(String firstName, String lastName, String middleName, Integer officerType, Integer officerCode, Instant datePrinyat, Instant dateUvolen, Status status, String login, String password, String role) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.middleName = middleName;
//        this.officerType = officerType;
//        this.officerCode = officerCode;
//        this.datePrinyat = datePrinyat;
//        this.dateUvolen = dateUvolen;
//        this.status = status;
//        this.login = login;
//        this.password = password;
//        this.role = role;
//    }

}

