package com.dreis.rateestimatemanager.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Rate {

    @Id
    private Long id;

    private LocalDate date;

    private BigDecimal rate;
}
