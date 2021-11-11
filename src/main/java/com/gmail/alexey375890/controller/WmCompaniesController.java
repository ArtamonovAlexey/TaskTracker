package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.model.WmCompanies;
import com.gmail.alexey375890.service.serviceInterface.WmCompaniesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-tracker/companies")
@Tag(
        name = "wm-companies-controller",
        description = "Кортроллер для регистрации и изменения компаний в бд"
)
public class WmCompaniesController {
    private final WmCompaniesService wmCompaniesService;

    public WmCompaniesController(WmCompaniesService wmCompaniesService) {
        this.wmCompaniesService = wmCompaniesService;
    }

    @Operation(
            summary = "Сохранение новой компании",
            description = "Сохранение новой компании в базу данных"
    )
    @PostMapping("/save")
    public WmCompanies saveCompany(
             @Parameter(description = "Добавляемая в базу данных компания")
             @RequestBody WmCompanies wmCompanies
    ) {
        return wmCompaniesService.save(wmCompanies);
    }

    @Operation(
            summary = "Получение компании",
            description = "Получение существующей компании по идентификатору из базы данных"
    )
    @GetMapping("/get-by-id/{id}")
    public WmCompanies getById(
            @Parameter(description = "Идентификатор сущестующей компании, которую хотим получить")
            @PathVariable Long id
    ) {
        return wmCompaniesService.get(id);
    }

    @Operation(
            summary = "Изменение наименования компании",
            description = "Изменение наименования существующей компании по идентификатору в базе данных"
    )
    @PutMapping("/put-name-by-id/{id}")
    public WmCompanies putNameById(
            @Parameter(description = "Идентификатор существующей компании, которую хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новое наименование для компании")
            @RequestBody String newName
    ) {
        return wmCompaniesService.updateNameOfCompany(id, newName);
    }

    @Operation(
            summary = "Удаление компании",
            description = "Удаление существующей компании по идентификатору из базы данных"
    )
    @DeleteMapping("/delete-by-id/{id}")
    public void deleteCompanyById(
            @Parameter(description = "Идентификатор сущестующей компании, которую хотим удалить")
            @PathVariable Long id
    ) {
        wmCompaniesService.delete(id);
    }
}
