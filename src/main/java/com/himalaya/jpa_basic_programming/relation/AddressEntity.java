package com.himalaya.jpa_basic_programming.relation;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
//@RequiredArgsConstructor
@Entity
@Table(name = "ADDRESS")
public class AddressEntity {

    @Id
    @GeneratedValue
    @Column(name = "ADDRESS_ID")
    private Long id;

    @Embedded
    private Address2 address;

    public AddressEntity(String city, String street, String zipcode) {
        this.address = new Address2(city, street, zipcode);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address2 getAddress() {
        return address;
    }

    public void setAddress(Address2 address) {
        this.address = address;
    }
}
