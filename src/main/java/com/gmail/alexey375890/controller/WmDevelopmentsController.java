package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.dto.WmDevelopmentsDTO;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTracker;
import com.gmail.alexey375890.service.serviceInterface.WmDevelopmentsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-tracker/developments")
public class WmDevelopmentsController {
    private final WmDevelopmentsService wmDevelopmentsService;

    public WmDevelopmentsController(WmDevelopmentsService wmDevelopmentsService) {
        this.wmDevelopmentsService = wmDevelopmentsService;
    }

    @PutMapping("/save")
    public WmDevelopments saveDevelopment(@RequestBody WmDevelopmentsDTO wmDevelopmentsDTO) {
        return wmDevelopmentsService.save(wmDevelopmentsDTO);
    }

    @GetMapping("/get-by-{id}")
    public WmDevelopments getDevelopmentById(@PathVariable Long id) {
        return wmDevelopmentsService.get(id);
    }

    @PostMapping("/post-updated-by-{id}")
    public WmDevelopments postUpdated(@PathVariable Long id, @RequestBody WmPeople newUpdated) {
        return wmDevelopmentsService.updateUpdated(id, newUpdated);
    }

    @PostMapping("/post-update-time-by-{id}")
    public WmDevelopments postUpdateTime(@PathVariable Long id, @RequestBody String newDate) {
        return wmDevelopmentsService.updateUpdateTime(id, newDate);
    }

    @PostMapping("/post-tracker-by-{id}")
    public WmDevelopments postTrackerById(@PathVariable Long id, @RequestBody WmTracker newTracker) {
        return wmDevelopmentsService.updateTracker(id, newTracker);
    }

    @PostMapping("/post-start-date-by-{id}")
    public WmDevelopments postStartDateById(@PathVariable Long id, @RequestBody String newStartDate) {
        return wmDevelopmentsService.updateStartDate(id, newStartDate);
    }

    @PostMapping("/post-end-date-by-{id}")
    public WmDevelopments postEndDateById(@PathVariable Long id, @RequestBody String newEndDate) {
        return wmDevelopmentsService.updateEndDate(id, newEndDate);
    }

    @PostMapping("/post-status-by-{id}")
    public WmDevelopments postStatusById(@PathVariable Long id, @RequestBody WmStatus newStatus) {
        return wmDevelopmentsService.updateStatus(id, newStatus);
    }

    @DeleteMapping("/delete-by-{id}")
    public void deleteDevelopmentById(@PathVariable Long id) {
        wmDevelopmentsService.delete(id);
    }
}
