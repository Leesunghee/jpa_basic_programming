package com.himalaya.jpa_basic_programming.relation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("M")
public class Movie2 extends Item2 {
    private String director;
    private String actor;
}
