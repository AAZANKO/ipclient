package com.aip.dao.dto;

import com.aip.dao.model.Officer;
import com.aip.dao.model.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDto {

    private Long id;
    private String account;
    private Integer clientNumber;
    private Integer collEmployee;
    private Instant dateclose;
    private Instant dateopen;
    private String address;
    private String name;
    private String shortName;
    private Integer status;
    private Integer unp;
    private Integer version;
    private Long officerId;
//    private Long officer,
    private Long relationtype1;
    private Long relationcode1;
    private Long relationtype2;
    private Long relationcode2;
    private Long relationtype3;
    private Long relationcode3;
    private Long relationtype4;
    private Long relationcode4;

//    private Long id;
//    private String clientNumber;
//    private String name;
//    private String shortName;
//    private Long analyticType;
//    private Long analyticCode;
//    private Instant dateOpen;
//    private Instant dateClose;
//    private Integer unp;
//    private String account;
//    private String legalCity;
//    private String legalStreet;
//    private String legalHouse;
//    private String territoryCity;
//    private String territoryStreet;
//    private String territoryHouse;
//    private Integer designationType;
//    private Integer designationCode;
//    private Integer countPerson;
//    private String status;
//    private String officer;

}
