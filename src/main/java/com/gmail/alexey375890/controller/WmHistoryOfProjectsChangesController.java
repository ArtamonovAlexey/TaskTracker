package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.dto.WmHistoryOfProjectsChangesDTO;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmProjects;
import com.gmail.alexey375890.service.serviceInterface.WmHistoryOfProjectsChangesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-tracker/history-of-projects-changes")
public class WmHistoryOfProjectsChangesController {
    private final WmHistoryOfProjectsChangesService wmHistoryOfProjectsChangesService;


    public WmHistoryOfProjectsChangesController(WmHistoryOfProjectsChangesService wmHistoryOfProjectsChangesService) {
        this.wmHistoryOfProjectsChangesService = wmHistoryOfProjectsChangesService;
    }

    @PutMapping("/save")
    public WmHistoryOfProjectsChanges saveHistoryOfProject(WmHistoryOfProjectsChangesDTO wmHistoryOfProjectsChangesDTO) {
        return wmHistoryOfProjectsChangesService.save(wmHistoryOfProjectsChangesDTO);
    }

    @GetMapping("/get-by-{id}")
    public WmHistoryOfProjectsChanges getById(@PathVariable Long id) {
        return wmHistoryOfProjectsChangesService.get(id);
    }

    @PostMapping("/post-number-by-{id}")
    public WmHistoryOfProjectsChanges postNumberById(@PathVariable Long id, @RequestBody WmProjects newNumber) {
        return wmHistoryOfProjectsChangesService.updateNumber(id, newNumber);
    }

    @PostMapping("/post-develop-by-{id}")
    public WmHistoryOfProjectsChanges postDevelopById(@PathVariable Long id, @RequestBody List<WmDevelopments> newDevelop) {
        return wmHistoryOfProjectsChangesService.updateDevelop(id, newDevelop);
    }

    @PostMapping("/post-start-date-by-{id}")
    public WmHistoryOfProjectsChanges postStartDateById(@PathVariable Long id, @RequestBody String newStartDate) {
        return wmHistoryOfProjectsChangesService.updateStartDate(id, newStartDate);
    }

    @PostMapping("/post-end-date-by-{id}")
    public WmHistoryOfProjectsChanges postEndDateById(@PathVariable Long id, @RequestBody String newEndDate) {
        return wmHistoryOfProjectsChangesService.updateEndDate(id, newEndDate);
    }

    @PostMapping("/post-respon-company-by-{id}")
    public WmHistoryOfProjectsChanges postResponCompanyById(@PathVariable Long id, @RequestBody WmPeople newResponCompany) {
        return wmHistoryOfProjectsChangesService.updateResponCompany(id, newResponCompany);
    }

    @PostMapping("/post-respon-of-client-company-by-{id}")
    public WmHistoryOfProjectsChanges postResponOfClientCompanyById(@PathVariable Long id, @RequestBody WmPeople newResponOfClientCompany) {
        return wmHistoryOfProjectsChangesService.updateResponOfClientCompany(id, newResponOfClientCompany);
    }

    @DeleteMapping("/delete-by-{id}")
    public void deleteHistoryOfProjectChangesById(@PathVariable Long id) {
        wmHistoryOfProjectsChangesService.delete(id);
    }
}
