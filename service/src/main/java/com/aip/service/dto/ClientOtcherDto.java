package com.aip.service.dto;

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

    private Long idClient;
    private String clientNumberClient;
    private String nameClient;
    private String shortNameClient;
    private Instant dateOpenClient;
    private Instant dateCloseClient;
    private Integer unpClient;
    private String accountClient;
    private String legalCityClient;
    private String legalStreetClient;
    private String legalHouseClient;
    private String territoryCityClient;
    private String territoryStreetClient;
    private String territoryHouseClient;
    private Integer designationTypeClient;
    private Integer designationCodeClient;
    private Integer countPersonClient;
    private String statusClient;
    private String firstNameOfficer;
    private String lastNameOfficer;
    private String middleNameOfficer;

}
