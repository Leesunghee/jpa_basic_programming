package com.himalaya.jpa_basic_programming.jpql;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Address3 {

    private String city;
    private String street;
    private String zipCode;
}
