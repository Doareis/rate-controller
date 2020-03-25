package com.dreis.rateestimatemanager.repository;

import com.dreis.rateestimatemanager.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate, Long> {

}
