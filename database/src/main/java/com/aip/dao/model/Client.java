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
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@Entity
@OptimisticLocking(type = OptimisticLockType.VERSION)
@Table(name = "client", schema = "opday")
@Component
public class Client extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "client_number")
    private String clientNumber;

    // unique = true - значение поля уникально
    // nullable = false - значение поля не может быть NULL
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "shortname", unique = true, nullable = false)
    private String shortName;

    @Column(name = "dateopen")
    private Instant dateOpen;

    @Column(name = "dateclose")
    private Instant dateClose;

    @Column(name = "unp")
    private Integer unp;

    @Column(name = "account")
    private String account;

//    // процент государственной собственности
//    @Column(name = "+ДОБАВИТЬ В БД+")
//    private Integer statePercent;

    @Column(name = "address")
    private String address;

//    @Embedded
//    private Addres addres;

//    @Column(name = "legal_city")
//    private String legalCity;
//
//    @Column(name = "legal_street")
//    private String legalStreet;
//
//    @Column(name = "legal_house")
//    private String legalHouse;
//
//    @Column(name = "territory_city")
//    private String territoryCity;
//
//    @Column(name = "territory_street")
//    private String territoryStreet;
//
//    @Column(name = "territory_house")
//    private String territoryHouse;

    @Column(name = "coll_employee")
    private Integer countPerson;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private Status status;

    @Version
    @Column(name = "version")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long version;

    @Column(name ="officer_id")
    private Long officerId;

    // Форма собственности
    @Column(name = "relationType1")
    private Long relationType1;
    @Column(name = "relationCode1")
    private Long relationCode1;

    // Организационно-правовая форма
    @Column(name = "relationType2")
    private Long relationType2;
    @Column(name = "relationCode2")
    private Long relationCode2;

    // Статус клиента
    @Column(name = "relationType3")
    private Long relationType3;
    @Column(name = "relationCode3")
    private Long relationCode3;

    // Вид деятельности
    @Column(name = "relationType4")
    private Long relationType4;
    @Column(name = "relationCode4")
    private Long relationCode4;

////    @ManyToOne
////    @JoinColumn(name = "officer_id")
////    private Officer officer;
//
//    @OneToMany(mappedBy = "client")
//    private Set<Anketa> anketa = new HashSet<>();
//
//    @OneToMany(mappedBy = "client")
//    private Set<Contract> contract = new HashSet<>();
//
//    @OneToMany(mappedBy = "client")
//    private Set<Graphik> graphik = new HashSet<>();
//
//    @OneToMany(mappedBy = "client")
//    private Set<Likvidaciya> likvidaciya = new HashSet<>();
//
//    @OneToMany(mappedBy = "client")
//    private Set<Person> person = new HashSet<>();

    public Client(String clientNumber, String name, String shortName, Instant dateOpen, Instant dateClose, Integer unp, String account, String address,  Integer countPerson, Status status, Long officerId, Long relationType1, Long relationCode1, Long relationType2, Long relationCode2, Long relationType3, Long relationCode3, Long relationType4, Long relationCode4) {
     //public Client(String clientNumber, String name, String shortName, Long analyticType, Long analyticCode, Instant dateOpen, Instant dateClose, Integer unp, String account, String legalCity, String legalStreet, String legalHouse, String territoryCity, String territoryStreet, String territoryHouse, Integer designationType, Integer designationCode, Integer countPerson, Status status, Officer officer) {
        this.clientNumber = clientNumber;
        this.name = name;
        this.shortName = shortName;
        this.dateOpen = dateOpen;
        this.dateClose = dateClose;
        this.unp = unp;
        this.account = account;
        this.address = address;
        this.countPerson = countPerson;
        this.status = status;
        //this.officer = officer;
        this.officerId = officerId;
        this.relationType1 = relationType1;
        this.relationCode1 = relationCode1;
        this.relationType2 = relationType2;
        this.relationCode2 = relationCode2;
        this.relationType3 = relationType3;
        this.relationCode3 = relationCode3;
        this.relationType4 = relationType4;
        this.relationCode4 = relationCode4;
    }

}

