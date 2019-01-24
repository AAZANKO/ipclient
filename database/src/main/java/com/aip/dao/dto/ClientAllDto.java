package com.aip.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientAllDto {

    private Number id;
    private Integer clientNumber;
    private String shortName;
    private String address;
    private Integer unp;
    private String dateOpen;
    private String dateClose;
    //    private String name;
    //    private Integer status;
    private Integer collEmployee;
    private String analyticNameOne;
    private String analyticNameTwo;
    private String analyticNameThree;
    private String analyticNameFour;
    private String officerName;

}
