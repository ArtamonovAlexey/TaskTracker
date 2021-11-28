package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.dto.filterDTO.*;
import com.gmail.alexey375890.model.*;
import com.gmail.alexey375890.service.filterService.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-tracker/filter")
public class FilterController {

    private final WmCompaniesFilterService wmCompaniesFilterService;
    private final WmDevelopmentsFilterService wmDevelopmentsFilterService;
    private final WmHistoryOfProjectsChangesFilterService wmHistoryOfProjectsChangesFilterService;
    private final WmPeopleFilterService wmPeopleFilterService;
    private final WmProjectsFilterService wmProjectsFilterService;
    private final WmTasksFilterService wmTasksFilterService;
    private final WmTeamsFilterService wmTeamsFilterService;

    public FilterController(WmCompaniesFilterService wmCompaniesFilterService,
                            WmDevelopmentsFilterService wmDevelopmentsFilterService,
                            WmHistoryOfProjectsChangesFilterService wmHistoryOfProjectsChangesFilterService,
                            WmPeopleFilterService wmPeopleFilterService,
                            WmProjectsFilterService wmProjectsFilterService,
                            WmTasksFilterService wmTasksFilterService,
                            WmTeamsFilterService wmTeamsFilterService
    ) {
        this.wmCompaniesFilterService = wmCompaniesFilterService;
        this.wmDevelopmentsFilterService = wmDevelopmentsFilterService;
        this.wmHistoryOfProjectsChangesFilterService = wmHistoryOfProjectsChangesFilterService;
        this.wmPeopleFilterService = wmPeopleFilterService;
        this.wmProjectsFilterService = wmProjectsFilterService;
        this.wmTasksFilterService = wmTasksFilterService;
        this.wmTeamsFilterService = wmTeamsFilterService;
    }

    @PostMapping("/companies")
    public List<WmCompanies> getListCompaniesByFilter(@RequestBody WmCompaniesFilterDTO filterDTO) {
        return wmCompaniesFilterService.filter(filterDTO);
    }

    @PostMapping("/developments")
    public List<WmDevelopments> getListDevelopmentsByFilter(@RequestBody WmDevelopmentsFilterDTO filterDTO) {
        return wmDevelopmentsFilterService.filter(filterDTO);
    }

    @PostMapping("/history-of-projects")
    public List<WmHistoryOfProjectsChanges> getListHistoryOfProjectsChangesByFilter(@RequestBody WmHistoryOfProjectsChangesFilterDTO filterDTO) {
        return wmHistoryOfProjectsChangesFilterService.filter(filterDTO);
    }

    @PostMapping("/people")
    public List<WmPeople> getListPeopleByFilter(@RequestBody WmPeopleFilterDTO filterDTO) {
        return wmPeopleFilterService.filter(filterDTO);
    }

    @PostMapping("/projects")
    public List<WmProjects> getListProjectsByFilter(@RequestBody WmProjectsFilterDTO filterDTO) {
        return wmProjectsFilterService.filter(filterDTO);
    }

    @PostMapping("/tasks")
    public List<WmTasks> getListTasksByFilter(@RequestBody WmTasksFilterDTO filterDTO) {
        return wmTasksFilterService.filter(filterDTO);
    }

    @PostMapping("/teams")
    public List<WmTeams> getListTeamsByFilter(@RequestBody WmTeamsFilterDTO filterDTO) {
        return wmTeamsFilterService.filter(filterDTO);
    }
}
