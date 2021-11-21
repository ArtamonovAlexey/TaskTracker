package com.gmail.alexey375890.controller.ofTable;

import com.gmail.alexey375890.dto.WmHistoryOfProjectsChangesDTO;
import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmHistoryOfProjectsChangesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-tracker/history-of-projects-changes")
@Tag(
        name = "wm-history-of-projects-changes-controller",
        description = "Контроллер для регистрации и изменения рестартов существующих проектов в бд"
)
public class WmHistoryOfProjectsChangesController {
    private final WmHistoryOfProjectsChangesService wmHistoryOfProjectsChangesService;


    public WmHistoryOfProjectsChangesController(WmHistoryOfProjectsChangesService wmHistoryOfProjectsChangesService) {
        this.wmHistoryOfProjectsChangesService = wmHistoryOfProjectsChangesService;
    }

    @Operation(
            summary = "Сохранение рестарта проекта",
            description = "Сохранение нового рестарта проекта, который до этого не существовал, в базе данных"
    )
    @PostMapping("/save")
    public WmHistoryOfProjectsChanges saveHistoryOfProject(
            @Parameter(description = "Добавляемый в базу данных рестарт проекта")
            @RequestBody WmHistoryOfProjectsChangesDTO wmHistoryOfProjectsChangesDTO
    ) {
        return wmHistoryOfProjectsChangesService.save(wmHistoryOfProjectsChangesDTO);
    }

    @Operation(
            summary = "Получение рестарта проекта",
            description = "Получение существующего рестарта проекта по идентификатору из базы данных"
    )
    @GetMapping("/get-by-id/{id}")
    public WmHistoryOfProjectsChanges getById(
            @Parameter(description = "Идентификатор сущестующего рестарта проекта, который хотим получить")
            @PathVariable Long id
    ) {
        return wmHistoryOfProjectsChangesService.get(id);
    }

    @Operation(
            summary = "Изменение проекта-родителя",
            description = "Изменение проекта-родителя по идентификатору в базе данных"
    )
    @PutMapping("/put-number-by-id/{id}")
    public WmHistoryOfProjectsChanges putNumberById(
            @Parameter(description = "Идентификатор существующего рестарта проекта, который хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новый проект-родитель")
            @RequestBody Long newNumberId
    ) {
        return wmHistoryOfProjectsChangesService.updateNumber(id, newNumberId);
    }

    @Operation(
            summary = "Изменение начальной даты рестарта проекта",
            description = "Изменение начальной даты существующего рестарта проекта по идентификатору в базе данных"
    )
    @PutMapping("/put-start-date-by-id/{id}")
    public WmHistoryOfProjectsChanges putStartDateById(
            @Parameter(description = "Идентификатор существующего рестарта проекта, который хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новая начальная дата")
            @RequestBody String newStartDate
    ) {
        return wmHistoryOfProjectsChangesService.updateStartDate(id, newStartDate);
    }

    @Operation(
            summary = "Изменение конечной даты рестарта проекта",
            description = "Изменение конечной даты существующего рестарта проекта по идентификатору в базе данных"
    )
    @PutMapping("/put-end-date-by-id/{id}")
    public WmHistoryOfProjectsChanges putEndDateById(
            @Parameter(description = "Идентификатор существующего рестарта проекта, который хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новая конечная дата")
            @RequestBody String newEndDate
    ) {
        return wmHistoryOfProjectsChangesService.updateEndDate(id, newEndDate);
    }

    @Operation(
            summary = "Замена ответственнного за проект от компании-разработчика",
            description = "Замена ответственного за проект от компании-разработчика по идентификатору в базе данных"
    )
    @PutMapping("/put-respon-company-by-id/{id}")
    public WmHistoryOfProjectsChanges putResponCompanyById(
            @Parameter(description = "Идентификатор существующего рестарта проекта, который хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новый отвественный за проект от компании-раработчика")
            @RequestBody Long newResponCompanyId
    ) {
        return wmHistoryOfProjectsChangesService.updateResponCompany(id, newResponCompanyId);
    }

    @Operation(
            summary = "Замена ответственного за проект от клиента",
            description = "Замена отвественного за проект от компании-клиента по идентификатору в базе данных"
    )
    @PutMapping("/put-respon-of-client-company-by-id/{id}")
    public WmHistoryOfProjectsChanges putResponOfClientCompanyById(
            @Parameter(description = "Идентификатор существующего рестарта проекта, который хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новый ответсвенный за проект от компании-клиента")
            @RequestBody Long newResponOfClientCompanyId
    ) {
        return wmHistoryOfProjectsChangesService.updateResponOfClientCompany(id, newResponOfClientCompanyId);
    }

    @Operation(
            summary = "Удаление рестарта проекта",
            description = "Удаление рестарта проекта по идентификатору из базы данных"
    )
    @DeleteMapping("/delete-by-id/{id}")
    public void deleteHistoryOfProjectChangesById(
            @Parameter(description = "Идентификатор сущестующего рестарта проекта, который хотим удалить")
            @PathVariable Long id
    ) {
        wmHistoryOfProjectsChangesService.delete(id);
    }

    @Operation(
            summary = "",
            description = ""
    )
    @PostMapping("/n-save/{id}")
    public WmHistoryOfProjectsChanges nSaveHistoryOfProjectChangesById(
            @Parameter(description = "Добавляемая в базу данных компания")
            @PathVariable Long id
    ) {
        return wmHistoryOfProjectsChangesService.nSave(id);
    }

    @Operation(
            summary = "",
            description = ""
    )
    @DeleteMapping("/n-delete-by-id/{id}")
    public void nDeleteHistoryOfProjectChangesById(
            @Parameter(description = "Идентификатор сущестующей компании, которую хотим удалить")
            @PathVariable Long id
    ) {
        wmHistoryOfProjectsChangesService.nDelete(id);
    }

}
