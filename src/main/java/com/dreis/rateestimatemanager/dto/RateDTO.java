package com.dreis.rateestimatemanager.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class RateDTO {
    private LocalDate date;

    private BigDecimal rate;
}
