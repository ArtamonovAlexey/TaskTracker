package com.gmail.alexey375890.controller.ofTable;

import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task-tracker/statuses")
@Tag(
        name = "",
        description = ""
)
public class WmStatusController {

    private final WmStatusService wmStatusService;

    public WmStatusController(WmStatusService wmStatusService) {
        this.wmStatusService = wmStatusService;
    }

    @Operation(
            summary = "",
            description = ""
    )
    @GetMapping("/get-by-id/{id}")
    public WmStatus getById(
            @Parameter(description = "")
            @PathVariable Long id) {
        return wmStatusService.get(id);
    }

    @Operation(
            summary = "",
            description = ""
    )
    @GetMapping("/get-done-status")
    public WmStatus getDoneStatusByRequest() {
        return wmStatusService.getDoneStatus();
    }

    @Operation(
            summary = "",
            description = ""
    )
    @GetMapping("/get-in-progress-status")
    public WmStatus getInProgressStatusByRequest() {
        return wmStatusService.getInProgressStatus();
    }

    @Operation(
            summary = "",
            description = ""
    )
    @GetMapping("/get-backlog-status")
    public WmStatus getBacklogStatusByRequest() {
        return wmStatusService.getBacklogStatus();
    }

    @Operation(
            summary = "",
            description = ""
    )
    @GetMapping("/get-active-status")
    public WmStatus getActiveStatusByRequest() {
        return wmStatusService.getActiveStatus();
    }

    @Operation(
            summary = "",
            description = ""
    )
    @GetMapping("/get-not-active-status")
    public WmStatus getNotActiveStatusByRequest() {
        return wmStatusService.getNotActiveStatus();
    }
}
