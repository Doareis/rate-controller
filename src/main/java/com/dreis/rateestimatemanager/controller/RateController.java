package com.dreis.rateestimatemanager.controller;

import com.dreis.rateestimatemanager.entity.Rate;
import com.dreis.rateestimatemanager.service.RateService;
import java.util.List;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Named
@Scope(value = "session")
@Component(value = "rateController")
@RestController
@RequestMapping("/rates")
public class RateController {

    @Autowired
    private RateService rateService;

    @RequestMapping("/all") //TODO return dto
    private List<Rate> findAll() {
        return rateService.findAll();
    }

    public void test() {
        System.out.println("teste");
    }

}
