package com.himalaya.jpa_basic_programming.jpashop.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie extends Item {

    private String director;
    private String actor;
}
