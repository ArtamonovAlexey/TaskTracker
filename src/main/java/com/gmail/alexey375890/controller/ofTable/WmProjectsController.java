package com.gmail.alexey375890.controller.ofTable;

import com.gmail.alexey375890.dto.WmProjectsDTO;
import com.gmail.alexey375890.model.WmProjects;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmProjectsService;
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
            @RequestBody WmProjectsDTO wmProjectsDTO
    ) {
        return wmProjectsService.save(wmProjectsDTO);
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
            @RequestBody Long newAuthorId
    ) {
        return wmProjectsService.updateAuthor(id, newAuthorId);
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
            @RequestBody Long newCompanyId
    ) {
        return wmProjectsService.updateCompany(id, newCompanyId);
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

    @Operation(
            summary = "",
            description = ""
    )
    @PostMapping("/n-save/{id}")
    public WmProjects nSaveProjectById(
            @Parameter(description = "Добавляемая в базу данных компания")
            @PathVariable Long id
    ) {
        return wmProjectsService.nSave(id);
    }

    @Operation(
            summary = "",
            description = ""
    )
    @DeleteMapping("/n-delete-by-id/{id}")
    public void nDeleteProjectById(
            @Parameter(description = "Идентификатор сущестующей компании, которую хотим удалить")
            @PathVariable Long id
    ) {
        wmProjectsService.nDelete(id);
    }

}
