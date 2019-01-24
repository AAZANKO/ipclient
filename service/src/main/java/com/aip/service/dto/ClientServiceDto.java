package com.aip.service.dto;

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
public class ClientServiceDto {
    private String id;
    private String clientNumber;		//номер клиента
    private String name;				//наименование
    private String shortName;			//короткое наименование
    private String analyticType;		//Тип аналитики
    private String analyticCode;		//Код аналитики
    private String dateOpen;			//Дата открытия
    private String dateClose;			//Дата закрытия
    private String unp;				    //УНП
    private String account;				//Счет
    //private String address;				//Адрес
    private String legalCity;			//Юр.адрес, город
    private String legalStreet;			//Юр.адрес, улица
    private String legalHouse;			//Юр.адрес, дом
    private String territoryCity;		//Физ.адрес, город
    private String territoryStreet;		//Физ.адрес, улица
    private String territoryHouse;		//Физ.адрес, дом
    private String designationType;	    //Тип обозначения
    private String designationCode;	    //Код обозначения
    private String countPerson;		    //Количество сотрудников
    private String status;				//Статус
    private String officer;			    //Исполнитель
}
