package com.gmail.alexey375890.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task-tracker/updating-data")
@Tag(
        name = "updating-data-controller",
        description = "Контроллер для обновления данных о выполнении или запаздывании разработки проекта"
)
public class UpdatingDataController {
//
//    private final UpdatingDataService updatingDataService;
//
//    public UpdatingDataController(UpdatingDataService updatingDataService) {
//        this.updatingDataService = updatingDataService;
//    }
//
//    @Operation(
//            summary = "",
//            description = ""
//    )
//    @PostMapping("/check-to-update-back-log-develop/{id}")
//    public boolean checkToUpdateBackLogDevelop(@PathVariable Long id) {
//        return updatingDataService.checkOnBackLogDevelop(id);
//    }
//
//    @Operation(
//            summary = "",
//            description = ""
//    )
//    @PostMapping("/check-to-update-done-develop/{id}")
//    public boolean checkToUpdateDoneDevelop(@PathVariable Long id) {
//        return updatingDataService.checkOnDoneDevelop(id);
//    }
//
//    @Operation(
//            summary = "",
//            description = ""
//    )
//    @PostMapping("/check-to-update-back-log-project/{id}")
//    public boolean checkToUpdateBackLogProject(@PathVariable Long id) {
//        return updatingDataService.checkOnBackLogProject(id);
//    }
//
//    @Operation(
//            summary = "",
//            description = ""
//    )
//    @PostMapping("/check-to-update-done-project/{id}")
//    public boolean checkToUpdateDoneProject(@PathVariable Long id) {
//        return updatingDataService.checkOnDoneProject(id);
//    }
}
