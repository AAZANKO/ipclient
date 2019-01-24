package com.aip.dao.dto;

import java.time.Instant;

public interface ClientDtoImpl {

//    public Long getId();
//    public Integer getClientNumber();
//    public String getName();
//    public String getShortName();
//    public Instant getDateOpen();
//    public Instant getDateClose();
//    public Integer getUnp();
//    public String getAccount();
//    public String getLegalCity();
//    public String getLegalStreet();
//    public String getLegalHouse();
//    public String getTerritoryCity();
//    public String getTerritoryStreet();
//    public String getTerritoryHouse();
//    public Integer getDesignationType();
//    public Integer getDesignationCode();
//    public Integer getCountPerson();
//    public String getStatus();


    public Long getId();
    public String getAccount();
    public Integer getClientNumber();
    public Integer getCollEmployee();
    public Instant getDateclose();
    public Instant getDateopen();
    public String getAddress();
    public String getName();
    public String getShortName();
    public Integer getStatus();
    public Integer getUnp();
    public Integer getVersion();
    public Long getOfficerId();
    public Long getRelationtype1();
    public Long getRelationcode1();
    public Long getRelationtype2();
    public Long getRelationcode2();
    public Long getRelationtype3();
    public Long getRelationcode3();
    public Long getRelationtype4();
    public Long getRelationcode4();
}

