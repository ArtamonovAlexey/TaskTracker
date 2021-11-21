package com.gmail.alexey375890.controller.ofTable;

import com.gmail.alexey375890.dto.WmPeopleDTO;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmPeopleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-tracker/people")
@Tag(
        name = "wm-people-controller",
        description = "Контроллер для регистрации и изменения данных людей, взаимодействующих с проектами в бд"
)
public class WmPeopleController {
    private final WmPeopleService wmPeopleService;

    public WmPeopleController(WmPeopleService wmPeopleService) {
        this.wmPeopleService = wmPeopleService;
    }

    @Operation(
            summary = "Сохранение данных человека",
            description = "Сохранение новых данных человека в базу данных"
    )
    @PostMapping("/save")
    public WmPeople savePerson(
            @Parameter(description = "Добавляемые в базу данных данные человека")
            @RequestBody WmPeopleDTO wmPeopleDTO
    ) {
        return wmPeopleService.save(wmPeopleDTO);
    }

    @Operation(
            summary = "Получение данных человека",
            description = "Получение данных существующего человека по идентификатору из базы данных"
    )
    @GetMapping("/get-by-id/{id}")
    public WmPeople getById(
            @Parameter(description = "Идентификатор сущестующих данных человека, которые хотим получить")
            @PathVariable Long id
    ) {
        return wmPeopleService.get(id);
    }

    @Operation(
            summary = "Изменение фамилии",
            description = "Изменение фамилии существующего человека по идентификатору в базе данных"
    )
    @PutMapping("/put-surname-by-id/{id}")
    public WmPeople putSurnameById(
            @Parameter(description = "Идентификатор существующих данных человека, которые хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новая фамилия")
            @RequestBody String newSurname
    ) {
        return wmPeopleService.updateSurname(id, newSurname);
    }

    @Operation(
            summary = "Изменение имени",
            description = "Изменение имени существующего человека по идентификатору в базе данных"
    )
    @PutMapping("/put-first-name-by-id/{id}")
    public WmPeople putFirstNameById(
            @Parameter(description = "Идентификатор существующих данных человека, которые хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новое имя")
            @RequestBody String newFirstName
    ) {
        return wmPeopleService.updateFirstName(id, newFirstName);
    }

    @Operation(
            summary = "Изменение отчества",
            description = "Изменение отчества существующего человека по идентификатору в базе данных"
    )
    @PutMapping("/put-second-name-by-id/{id}")
    public WmPeople putSecondName(
            @Parameter(description = "Идентификатор существующих данных человека, которые хотим изменить")
            @PathVariable Long id,

            @Parameter(description = "Новое отчество")
            @RequestBody String newSecondName
    ) {
        return wmPeopleService.updateSecondName(id, newSecondName);
    }

    @Operation(
            summary = "Удаление данных человека",
            description = "Удаление данных существующего человека по идентификатору из базы данных"
    )
    @DeleteMapping("/delete-by-id/{id}")
    public void deletePersonById(
            @Parameter(description = "Идентификатор сущестующих данных человека, которые хотим удалить")
            @PathVariable Long id
    ) {
        wmPeopleService.delete(id);
    }

    @Operation(
            summary = "",
            description = ""
    )
    @PostMapping("/n-save/{id}")
    public WmPeople nSavePersonById(
            @Parameter(description = "Добавляемая в базу данных компания")
            @PathVariable Long id
    ) {
        return wmPeopleService.nSave(id);
    }

    @Operation(
            summary = "",
            description = ""
    )
    @DeleteMapping("/n-delete-by-id/{id}")
    public void nDeletePersonById(
            @Parameter(description = "Идентификатор сущестующей компании, которую хотим удалить")
            @PathVariable Long id
    ) {
        wmPeopleService.nDelete(id);
    }

}
