package com.aip.dao.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Component
@Embeddable
public class Addres {

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;
}

// save(Client.builder().name("").shortNamme("").....addres(Addres.of("Minsk", "Nekrasova", "7")).build());