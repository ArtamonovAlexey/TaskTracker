package com.gmail.alexey375890.controller.ofTable;

import com.gmail.alexey375890.model.WmTracker;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmTrackerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task-tracker/trackers")
@Tag(
        name = "",
        description = ""
)
public class WmTrackerController {
    private final WmTrackerService wmTrackerService;

    public WmTrackerController(WmTrackerService wmTrackerService) {
        this.wmTrackerService = wmTrackerService;
    }

    @Operation(
            summary = "",
            description = ""
    )
    @GetMapping("/get-by-id/{id}")
    public WmTracker getById(
            @Parameter(description = "")
            @PathVariable Long id) {
        return wmTrackerService.get(id);
    }

    @Operation(
            summary = "",
            description = ""
    )
    @GetMapping("/get-backend-rework-tracker")
    public WmTracker getBackendReworkTrackerByRequest() {
        return wmTrackerService.getBackendReworkTracker();
    }

    @Operation(
            summary = "",
            description = ""
    )
    @GetMapping("/get-backend-development-tracker")
    public WmTracker getBackendDevelopmentTrackerByRequest() {
        return wmTrackerService.getBackendDevelopmentTracker();
    }

    @Operation(
            summary = "",
            description = ""
    )
    @GetMapping("/get-frontend-rework-tracker")
    public WmTracker getFrontendReworkTrackerByRequest() {
        return wmTrackerService.getFrontendReworkTracker();
    }

    @Operation(
            summary = "",
            description = ""
    )
    @GetMapping("/get-frontend-development-tracker")
    public WmTracker getFrontendDevelopmentTrackerByRequest() {
        return wmTrackerService.getFrontendDevelopmentTracker();
    }

    @Operation(
            summary = "",
            description = ""
    )
    @GetMapping("/get-qa-tracker")
    public WmTracker getQaTrackerByRequest() {
        return wmTrackerService.getQaTracker();
    }
}
