package com.himalaya.jpa_basic_programming.jpql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@NamedQuery(
        name = "Member3.findByUsername",
        query = "select m from Member3 m where m.username = :username"
)
public class Member3 {

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team3 team;

    @Override
    public String toString() {
        return "Member3{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", team=" + team +
                '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setTeam(Team3 team) {
        this.team = team;
        this.team.getMember3s().add(this);
    }
}
