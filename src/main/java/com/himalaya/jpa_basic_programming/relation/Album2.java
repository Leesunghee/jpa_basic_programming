package com.himalaya.jpa_basic_programming.relation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album2 extends Item2 {

    private String artist;
}
