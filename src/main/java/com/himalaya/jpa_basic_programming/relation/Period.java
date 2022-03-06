package com.himalaya.jpa_basic_programming.relation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Period {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public boolean isWork() {
        return false;
    }
}
