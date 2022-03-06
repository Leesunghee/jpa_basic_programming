package com.himalaya.jpa_basic_programming.jpql;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Team3 {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

//    @BatchSize(size = 100)
    @OneToMany(mappedBy = "team")
    private List<Member3> member3s = new ArrayList<>();

}
