package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.dto.WmTasksDTO;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTasks;
import com.gmail.alexey375890.service.serviceInterface.WmTasksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-tracker/tasks")
@Tag(
        name = "wm-tasks-controller",
        description = "Контроллер для регистрации и изменения задач в разработках проекта в бд"
)
public class WmTasksController {
    private final WmTasksService wmTasksService;

    public WmTasksController(WmTasksService wmTasksService) {
        this.wmTasksService = wmTasksService;
    }

    @Operation(
            summary = "Сохранение задачи",
            description = "Сохранение новой задачи в базу данных"
    )
    @PostMapping("/save")
    public WmTasks saveTask(
            @Parameter(description = "Добавляемая в базу данных задача")
            @RequestBody WmTasksDTO wmTasksDTO
    ) {
        return wmTasksService.save(wmTasksDTO);
    }

    @Operation(
            summary = "Получение задачи",
            description = "Получение существующей задачи по идентификатору из базы данных"
    )
    @GetMapping("/get-by-id/{id}")
    public WmTasks getById(
            @Parameter(description = "Идентификатор сущестующей задачи, которую хотим получить")
            @PathVariable Long id
    ) {
        return wmTasksService.get(id);
    }

    @Operation(
            summary = "Изменение названия задачи",
            description = "Изменение названия существующей задачи по идентификатору в базе данных"
    )
    @PutMapping("/put-name-by-id/{id}")
    public WmTasks putNameById(
            @Parameter(description = "")
            @PathVariable Long id,

            @Parameter(description = "Новое название задачи")
            @RequestBody String newName
    ) {
        return wmTasksService.updateName(id, newName);
    }

    @Operation(
            summary = "Изменение даты решения задачи",
            description = "Изменение даты решения существующей задачи по идентификатору в базе данных"
    )
    @PutMapping("/put-date-by-id/{id}")
    public WmTasks putDateById(
            @Parameter(description = "Идентификатор существующей задачи, которую хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новая дата решения задачи")
            @RequestBody String newDate
    ) {
        return wmTasksService.updateDate(id, newDate);
    }

    @Operation(
            summary = "Изменение статуса задачи",
            description = "Изменение статуса существующей задачи по идентификатору в базе данных"
    )
    @PutMapping("/put-status-by-id/{id}")
    public WmTasks putStatusById(
            @Parameter(description = "Идентификатор существующей задачи, которую хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новый статус задачи")
            @RequestBody WmStatus newStatus
    ) {
        return wmTasksService.updateStatus(id, newStatus);
    }

    @Operation(
            summary = "Замена разработки задачи",
            description = "Замена разработки существующей задачи по идентификатору в базе данных"
    )
    @PutMapping("/put-develop-by-id/{id}")
    public WmTasks putDevelopById(
            @Parameter(description = "Идентификатор существующей задачи, которую хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новая разработка задачи")
            @RequestBody WmDevelopments newDevelop
    ) {
        return wmTasksService.updateDevelop(id, newDevelop);
    }

    @Operation(
            summary = "Удаление задачи",
            description = "Удаление существующей задачи по идентификатору из базы данных"
    )
    @DeleteMapping("/delete-by-id/{id}")
    public void deleteById(
            @Parameter(description = "Идентификатор сущестующей задачи, которую хотим удалить")
            @PathVariable Long id
    ) {
        wmTasksService.delete(id);
    }
}
