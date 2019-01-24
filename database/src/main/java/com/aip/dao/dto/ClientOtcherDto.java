package com.aip.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientOtcherDto {

    private Long id;
    private String clientNumber;
    private String name;
    private String shortName;
    private Instant dateOpen;
    private Instant dateClose;
    private Integer unp;
    private String account;
    private String legalCity;
    private String legalStreet;
    private String legalHouse;
    private String territoryCity;
    private String territoryStreet;
    private String territoryHouse;
    private Integer designationType;
    private Integer designationCode;
    private Integer countPerson;
    private String status;
    private String firstName;
    private String lastName;
    private String middleName;

}
