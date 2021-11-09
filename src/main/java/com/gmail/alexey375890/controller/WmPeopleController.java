package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.service.serviceInterface.WmPeopleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-tracker/people")
public class WmPeopleController {
    private final WmPeopleService wmPeopleService;

    public WmPeopleController(WmPeopleService wmPeopleService) {
        this.wmPeopleService = wmPeopleService;
    }

    @PutMapping("/save")
    public WmPeople savePerson(WmPeople wmPeople) {
        return wmPeopleService.save(wmPeople);
    }

    @PostMapping("/post-surname-by-{id}")
    public WmPeople postSurnameById(@PathVariable Long id, @RequestBody String newSurname) {
        return wmPeopleService.updateSurname(id, newSurname);
    }

    @PostMapping("/post-first-name-by-{id}")
    public WmPeople postFirstNameById(@PathVariable Long id, @RequestBody String newFirstName) {
        return wmPeopleService.updateFirstName(id, newFirstName);
    }

    @PostMapping("/post-second-name-by-{id}")
    public WmPeople postSecondName(@PathVariable Long id, @RequestBody String newSecondName) {
        return wmPeopleService.updateSecondName(id, newSecondName);
    }

    @DeleteMapping("/delete-by-{id}")
    public void deletePersonById(@PathVariable Long id) {
        wmPeopleService.delete(id);
    }
}
