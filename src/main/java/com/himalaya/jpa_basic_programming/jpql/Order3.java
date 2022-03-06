package com.himalaya.jpa_basic_programming.jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ORDERS3")
public class Order3 {

    @Id
    @GeneratedValue
    private Long id;
    private int orderAmount;

    @Embedded
    private Address3 address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product3 product;
}
