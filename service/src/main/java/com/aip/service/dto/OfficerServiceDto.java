package com.aip.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfficerServiceDto {

    private String firstName;
    private String lastName;
    private String middleName;
    private String officerType;
    private String officerCode;
    private String datePrinyat;
    private String dateUvolen;
    private String status;
    private String login;
    private String password;
    private String role;
}
