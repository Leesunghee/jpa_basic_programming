package com.himalaya.jpa_basic_programming.relation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Item2 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
