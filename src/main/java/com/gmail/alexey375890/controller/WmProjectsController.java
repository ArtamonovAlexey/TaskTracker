package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.model.WmCompanies;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmProjects;
import com.gmail.alexey375890.service.serviceInterface.WmProjectsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-tracker/projects")
@Tag(
        name = "wm-projects-controller",
        description = "Контроллер для регистрации и изменения новых проектов в бд"
)
public class WmProjectsController {
    private final WmProjectsService wmProjectsService;

    public WmProjectsController(WmProjectsService wmProjectsService) {
        this.wmProjectsService = wmProjectsService;
    }

    @Operation(
            summary = "Сохранение проекта",
            description = "Сохранение нового проекта в базу данных"
    )
    @PostMapping("/save")
    public WmProjects saveProject(
            @Parameter(description = "Добавляемый в базу данных проект")
            @RequestBody WmProjects wmProjects
    ) {
        return wmProjectsService.save(wmProjects);
    }

    @Operation(
            summary = "Получение проекта",
            description = "Получение существующего проекта по идентификатору из базы данных"
    )
    @GetMapping("get-by-id/{id}")
    public WmProjects getById(
            @Parameter(description = "Идентификатор сущестующего проекта, который хотим получить")
            @PathVariable Long id
    ) {
        return wmProjectsService.get(id);
    }

    @Operation(
            summary = "Изменение названия проекта",
            description = "Изменение названия существующего проекта по идентификатору в базе данных"
    )
    @PutMapping("/put-title-by-id/{id}")
    public WmProjects putTitleById(
            @Parameter(description = "Идентификатор существующего проекта, который хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новое название проекта")
            @RequestBody String newTitle
    ) {
        return wmProjectsService.updateTitle(id, newTitle);
    }

    @Operation(
            summary = "Замена автора проекта",
            description = "Замена существующего автора проекта по идентификатору в базе данных"
    )
    @PutMapping("/put-author-by-id/{id}")
    public WmProjects putAuthorById(
            @Parameter(description = "Идентификатор существующего проекта, который хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новый автор")
            @RequestBody WmPeople newAuthor
    ) {
        return wmProjectsService.updateAuthor(id, newAuthor);
    }

    @Operation(
            summary = "Замена клиентской компании",
            description = "Замена существующей клиентской компании по идентификатору в базе данных"
    )
    @PutMapping("/put-company-by-id/{id}")
    public WmProjects putCompanyById(
            @Parameter(description = "Идентификатор существующего проекта, который хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новая клиентская компания")
            @RequestBody WmCompanies newCompany
    ) {
        return wmProjectsService.updateCompany(id, newCompany);
    }

    @Operation(
            summary = "Удаление проекта",
            description = "Удаление существующего проекта по идентификатору из базы данных"
    )
    @DeleteMapping("/delete-by-id/{id}")
    public void deleteProjectById(
            @Parameter(description = "Идентификатор сущестующего проекта, который хотим удалить")
            @PathVariable Long id
    ) {
        wmProjectsService.delete(id);
    }
}
