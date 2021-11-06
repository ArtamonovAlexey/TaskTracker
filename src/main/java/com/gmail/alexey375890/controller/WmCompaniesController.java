package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.model.WmCompanies;
import com.gmail.alexey375890.service.serviceImpl.WmCompaniesServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class WmCompaniesController {

    private final WmCompaniesServiceImpl wmCompaniesServiceImpl;

    public WmCompaniesController(WmCompaniesServiceImpl wmCompaniesServiceImpl) {
        this.wmCompaniesServiceImpl = wmCompaniesServiceImpl;
    }


    @GetMapping("/")
    public void get() {
        WmCompanies wmCompanies = new WmCompanies(2l, "Basis");
//        System.out.println(wmCompanies);
        System.out.println(wmCompaniesServiceImpl.save(wmCompanies));
    }
}
