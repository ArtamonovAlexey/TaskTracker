package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.model.WmCompanies;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmProjects;
import com.gmail.alexey375890.service.serviceInterface.WmProjectsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-tracker/projects")
public class WmProjectsController {
    private final WmProjectsService wmProjectsService;

    public WmProjectsController(WmProjectsService wmProjectsService) {
        this.wmProjectsService = wmProjectsService;
    }

    @PutMapping("/save")
    public WmProjects saveProject(WmProjects wmProjects) {
        return wmProjectsService.save(wmProjects);
    }

    @GetMapping("get-by-{id}")
    public WmProjects getById(@PathVariable Long id) {
        return wmProjectsService.get(id);
    }

    @PostMapping("/post-title-by-{id}")
    public WmProjects postTitleById(@PathVariable Long id, @RequestBody String newTitle) {
        return wmProjectsService.updateTitle(id, newTitle);
    }

    @PostMapping("/post-author-by-{id}")
    public WmProjects postAuthorById(@PathVariable Long id, @RequestBody WmPeople newAuthor) {
        return wmProjectsService.updateAuthor(id, newAuthor);
    }

    @PostMapping("/post-company-by-{id}")
    public WmProjects postCompanyById(@PathVariable Long id, WmCompanies newCompany) {
        return wmProjectsService.updateCompany(id, newCompany);
    }

    @DeleteMapping("/delete-by-{id}")
    public void deleteProjectById(@PathVariable Long id) {
        wmProjectsService.delete(id);
    }
}
