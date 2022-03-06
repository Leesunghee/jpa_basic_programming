package com.himalaya.jpa_basic_programming.relation;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class   BaseEntity {

    private String createBy;
    private LocalDateTime createDateTime;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedDateTime;


}
