package com.gmail.alexey375890.controller;

import com.gmail.alexey375890.dto.WmTasksDTO;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTasks;
import com.gmail.alexey375890.service.serviceInterface.WmTasksService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-tracker/tasks")
public class WmTasksController {
    private final WmTasksService wmTasksService;

    public WmTasksController(WmTasksService wmTasksService) {
        this.wmTasksService = wmTasksService;
    }

    @PutMapping("/save")
    public WmTasks saveTask(WmTasksDTO wmTasksDTO) {
        return wmTasksService.save(wmTasksDTO);
    }

    @GetMapping("/get-by-{id}")
    public WmTasks getById(@PathVariable Long id) {
        return wmTasksService.get(id);
    }

    @PostMapping("/post-name-by-{id}")
    public WmTasks postNameById(@PathVariable Long id, @RequestBody String newName) {
        return wmTasksService.updateName(id, newName);
    }

    @PostMapping("/post-date-by-{id}")
    public WmTasks postDateById(@PathVariable Long id, @RequestBody String newDate) {
        return wmTasksService.updateDate(id, newDate);
    }

    @PostMapping("/post-status-by-{id}")
    public WmTasks postStatusById(@PathVariable Long id, @RequestBody WmStatus newStatus) {
        return wmTasksService.updateStatus(id, newStatus);
    }

    @PostMapping("/post-develop-by-{id}")
    public WmTasks postDevelopById(@PathVariable Long id, WmDevelopments newDevelop) {
        return wmTasksService.updateDevelop(id, newDevelop);
    }

    @DeleteMapping("/delete-by-{id}")
    public void deleteById(@PathVariable Long id) {
        wmTasksService.delete(id);
    }
}
