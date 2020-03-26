package com.dreis.rateestimatemanager.service;

import com.dreis.rateestimatemanager.dto.RateDTO;
import com.dreis.rateestimatemanager.entity.Rate;
import com.dreis.rateestimatemanager.repository.RateRepository;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RateService {

    @Autowired
    private RateRepository rateRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public List<Rate> findAll() {
        return rateRepository.findAll();
    }

    public void saveAll(List<RateDTO> rates) {
        rates.forEach(rate -> rateRepository.save(modelMapper.map(rate, Rate.class)));
    }
}
