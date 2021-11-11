package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.dto.WmDevelopmentsDTO;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTracker;
import com.gmail.alexey375890.service.serviceInterface.WmDevelopmentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-tracker/developments")
@Tag(
        name = "wm-developments-controller",
        description = "Контроллер для регистрации и изменения разработок в бд"
)
public class WmDevelopmentsController {
    private final WmDevelopmentsService wmDevelopmentsService;

    public WmDevelopmentsController(WmDevelopmentsService wmDevelopmentsService) {
        this.wmDevelopmentsService = wmDevelopmentsService;
    }

    @Operation(
            summary = "Сохранение разработки",
            description = "Сохранение новой разработки в базу данных"
    )
    @PostMapping("/save")
    public WmDevelopments saveDevelopment(
            @Parameter(description = "Добавляемая в базу данных разработка")
            @RequestBody WmDevelopmentsDTO wmDevelopmentsDTO
    ) {
        return wmDevelopmentsService.save(wmDevelopmentsDTO);
    }

    @Operation(
            summary = "Получение разработки",
            description = "Получение существующей разработки по идентифактору из базы данных"
    )
    @GetMapping("/get-by-id/{id}")
    public WmDevelopments getDevelopmentById(
            @Parameter(description = "Идентификатор сущестующей разработки, которую хотим получить")
            @PathVariable Long id
    ) {
        return wmDevelopmentsService.get(id);
    }

    @Operation(
            summary = "Изменение человека, который последний обновлял проект",
            description = "Изменение человека, который учавствует в существующей " +
                    "разработке проекта и который последний обновлял его, по идентификатору в базе данных"
    )
    @PutMapping("/put-updated-by-id/{id}")
    public WmDevelopments putUpdated(
            @Parameter(description = "Идентификатор существующей разработки, которую хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новый человек, который последний изменил проект")
            @RequestBody WmPeople newUpdated
    ) {
        return wmDevelopmentsService.updateUpdated(id, newUpdated);
    }

    @Operation(
            summary = "Изменение даты последнего обновления",
            description = "Изменение даты последнего обновления по идентификатору в базе данных"
    )
    @PutMapping("/put-update-time-by-id/{id}")
    public WmDevelopments putUpdateTime(
            @Parameter(description = "Идентификатор существующей разработки, которую хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новая дата последнего обновления")
            @RequestBody String newDate
    ) {
        return wmDevelopmentsService.updateUpdateTime(id, newDate);
    }

    @Operation(
            summary = "Изменение трекера разработки",
            description = "Изменение трекера существующей разработки по идентификатору в базе данных"
    )
    @PutMapping("/put-tracker-by-id/{id}")
    public WmDevelopments putTrackerById(
            @Parameter(description = "Идентификатор существующей разработки, которую хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новый трекер разработки")
            @RequestBody WmTracker newTracker
    ) {
        return wmDevelopmentsService.updateTracker(id, newTracker);
    }

    @Operation(
            summary = "Изменение начальной даты разработки",
            description = "Изменение начальной даты существующей разработки по идентификатору в базе данных"
    )
    @PutMapping("/put-start-date-by-id/{id}")
    public WmDevelopments putStartDateById(
            @Parameter(description = "Идентификатор существующей разработки, которую хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новая начальная дата")
            @RequestBody String newStartDate
    ) {
        return wmDevelopmentsService.updateStartDate(id, newStartDate);
    }

    @Operation(
            summary = "Изменение конечной даты разработки",
            description = "Изменение конечной даты существующей разработки по идентификатору в базе данных"
    )
    @PutMapping("/put-end-date-by-id/{id}")
    public WmDevelopments putEndDateById(
            @Parameter(description = "Идентификатор существующей разработки, которую хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новая конечная дата")
            @RequestBody String newEndDate
    ) {
        return wmDevelopmentsService.updateEndDate(id, newEndDate);
    }

    @Operation(
            summary = "Изменение статуса разработки",
            description = "Изменение статуса существующей разработки по идентификатору в базе данных"
    )
    @PutMapping("/put-status-by-id/{id}")
    public WmDevelopments putStatusById(
            @Parameter(description = "Идентификатор существующей разработки, которую хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новый статус разработки")
            @RequestBody WmStatus newStatus
    ) {
        return wmDevelopmentsService.updateStatus(id, newStatus);
    }

    @Operation(
            summary = "Удаление разработки",
            description = "Удаление существующей разработки по идентификатору из базы данных"
    )
    @DeleteMapping("/delete-by-id/{id}")
    public void deleteDevelopmentById(
            @Parameter(description = "Идентификатор сущестующей разработки, которую хотим удалить")
            @PathVariable Long id
    ) {
        wmDevelopmentsService.delete(id);
    }
}
