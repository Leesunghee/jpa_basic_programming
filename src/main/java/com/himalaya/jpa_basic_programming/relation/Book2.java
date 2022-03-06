package com.himalaya.jpa_basic_programming.relation;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class Book2 extends Item2 {

    private String author;
    private String isbn;
}
