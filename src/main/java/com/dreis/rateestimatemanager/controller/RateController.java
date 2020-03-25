package com.dreis.rateestimatemanager.controller;

import com.dreis.rateestimatemanager.entity.Rate;
import com.dreis.rateestimatemanager.repository.RateRepository;
import java.util.List;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rate")

@Named
@Scope(value = "session")
@Component(value = "rateController")
public class RateController {

    @Autowired
    private RateRepository rateRepository;

    @RequestMapping("/all") //TODO return dto
    private List<Rate> findAll() {
        return rateRepository.findAll();
    }

    public void test() {
        System.out.println("teste");
    }

}
