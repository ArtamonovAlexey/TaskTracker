package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.dto.WmTeamsDTO;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmTeams;
import com.gmail.alexey375890.service.serviceInterface.WmTeamsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-tracker/teams")
@Tag(
        name = "wm-teams-controller",
        description = "Контроллер для регистрации и изменения команд-разработчиков в бд"
)
public class WmTeamsController {
    private final WmTeamsService wmTeamsService;

    public WmTeamsController(WmTeamsService wmTeamsService) {
        this.wmTeamsService = wmTeamsService;
    }

    @Operation(
            summary = "Сохранение команды разработчиков",
            description = "Сохранение нового участника команды разработчиков в базу данных"
    )
    @PostMapping("/save")
    public WmTeams saveTeam(
            @Parameter(description = "Добавляемый в базу данных участник команды разработчиков")
            @RequestBody WmTeamsDTO team
    ) {
        return wmTeamsService.save(team);
    }

    @Operation(
            summary = "Получение команды разработчиков",
            description = "Получение существующего участника команды разработчиков по идентификатору из базы данных"
    )
    @GetMapping("/get-by-id/{id}")
    public WmTeams getById(
            @Parameter(description = "Идентификатор сущестующего участника команды " +
                    "разработчиков, которого хотим получить")
            @PathVariable Long id
    ) {
        return wmTeamsService.get(id);
    }

    @Operation(
            summary = "Замена разработчика на другого",
            description = "Замена существующего участника команды разработчиков по идентификатору в базе данных"
    )
    @PutMapping("/put-person-by-id/{id}")
    public WmTeams putPersonById(
            @Parameter(description = "Идентификатор существующего участника команды " +
                    "разработчиков, которого хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новый разработчик")
            @RequestBody WmPeople newPerson
    ) {
        return wmTeamsService.updatePerson(id, newPerson);
    }

    @Operation(
            summary = "Изменение разработки",
            description = "Изменение существующей разработки по идентификатору в базе данных"
    )
    @PutMapping("/put-develop-by-id/{id}")
    public WmTeams putDevelopById(
            @Parameter(description = "Идентификатор существующего участника команды " +
                    "разработчиков, которого хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новая разработка")
            @RequestBody WmDevelopments newDevelop
    ) {
        return wmTeamsService.updateTeam(id, newDevelop);
    }

    @Operation(
            summary = "Изменение начальной даты существования в команде",
            description = "Изменение начальной даты существования " +
                    "существующего участника команды разработчиков по идентификатору в базе данных"
    )
    @PutMapping("/put-start-date-by-id/{id}")
    public WmTeams putStartDateById(
            @Parameter(description = "Идентификатор существующего участника команды " +
                    "разработчиков, которого хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новая начальная дата сущестования в команде разработчиков")
            @RequestBody String newStartDate
    ) {
        return wmTeamsService.updateStartDate(id, newStartDate);
    }

    @Operation(
            summary = "Изменение конечной даты существования в команде",
            description = "Изменение конечной даты существования существующего " +
                    "разработчика команды разработчиков по идентификатору в базе данных"
    )
    @PutMapping("/put-end-date-by-id/{id}")
    public WmTeams putEndDateById(
            @Parameter(description = "Идентификатор существующего участника команды " +
                    "разработчиков, которого хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новая конечная дата существования в команде разработчиков")
            @RequestBody String newEndDate
    ) {
        return wmTeamsService.updateEndDate(id, newEndDate);
    }

    @Operation(
            summary = "Удаление участника команды разработчиков",
            description = "Удаление существующего участника команды разработчиков по идентификатору из базы данных"
    )
    @DeleteMapping("/delete-by-id/{id}")
    public void deleteTeamById(
            @Parameter(description = "Идентификатор сущестующего участника команды " +
                    "разработчиков, которого хотим удалить")
            @PathVariable Long id
    ) {
        wmTeamsService.delete(id);
    }
}
