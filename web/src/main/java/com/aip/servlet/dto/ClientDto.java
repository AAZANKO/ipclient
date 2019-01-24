package com.aip.servlet.dto;

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
    private String clientNumber;
    private String name;
    private String shortName;
    private Long analyticType;
    private Long analyticCode;
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
    private Status status; // если открывается то OPEN
    private Long officerId; // при сохранении брать из сессии
}
