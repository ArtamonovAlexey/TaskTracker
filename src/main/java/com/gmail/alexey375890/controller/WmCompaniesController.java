package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.model.WmCompanies;
import com.gmail.alexey375890.service.serviceInterface.WmCompaniesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-tracker/companies")
//@Api("Controller for works with data of companies")
@Tag(name = "", description = "")
public class WmCompaniesController {
    private final WmCompaniesService wmCompaniesService;

    public WmCompaniesController(WmCompaniesService wmCompaniesService) {
        this.wmCompaniesService = wmCompaniesService;
    }

    @PutMapping("/save")
    public WmCompanies saveCompany(@RequestBody WmCompanies wmCompanies) {
        return wmCompaniesService.save(wmCompanies);
    }

    @GetMapping("/get-by-{id}")
    public WmCompanies getById(@PathVariable Long id) {
        return wmCompaniesService.get(id);
    }

    @PostMapping("/post-name-by-{id}")
    public WmCompanies postNameById(@PathVariable Long id, @RequestBody String newName) {
        return wmCompaniesService.updateNameOfCompany(id, newName);
    }

    @DeleteMapping("/delete-by-{id}")
    public void deleteCompanyById(@PathVariable Long id) {
        wmCompaniesService.delete(id);
    }
}
