package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.dto.WmTeamsDTO;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmTeams;
import com.gmail.alexey375890.service.serviceInterface.WmTeamsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-tracker/teams")
public class WmTeamsController {
    private final WmTeamsService wmTeamsService;

    public WmTeamsController(WmTeamsService wmTeamsService) {
        this.wmTeamsService = wmTeamsService;
    }

    @PutMapping("/save")
    public WmTeams saveTeam(WmTeamsDTO team) {
        return wmTeamsService.save(team);
    }

    @GetMapping("/get-by-{id}")
    public WmTeams getById(@PathVariable Long id) {
        return wmTeamsService.get(id);
    }

    @PostMapping("/post-person-by-{id}")
    public WmTeams postPersonById(@PathVariable Long id, @RequestBody WmPeople newPerson) {
        return wmTeamsService.updatePerson(id, newPerson);
    }

    @PostMapping("/post-develop-by-{id}")
    public WmTeams postDevelopById(@PathVariable Long id, @RequestBody WmDevelopments newDevelop) {
        return wmTeamsService.updateTeam(id, newDevelop);
    }

    @PostMapping("/post-start-date-by-{id}")
    public WmTeams postStartDateById(@PathVariable Long id, @RequestBody String newStartDate) {
        return wmTeamsService.updateStartDate(id, newStartDate);
    }

    @PostMapping("/post-end-date-by-{id}")
    public WmTeams postEndDateById(@PathVariable Long id, @RequestBody String newEndDate) {
        return wmTeamsService.updateEndDate(id, newEndDate);
    }

    @DeleteMapping("/delete-by-{id}")
    public void deleteTeamById(@PathVariable Long id) {
        wmTeamsService.delete(id);
    }
}
