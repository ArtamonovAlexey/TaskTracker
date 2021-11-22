package com.gmail.alexey375890.service.serviceInterface.ofTable;

import com.gmail.alexey375890.dto.WmTasksDTO;
import com.gmail.alexey375890.model.WmTasks;

public interface WmTasksService {
    WmTasks save(WmTasksDTO task);

    WmTasks get(Long id);

    WmTasks updateName(Long id, String newName);

    WmTasks updateDate(Long id, String newDate);

    WmTasks updateStatus(Long id, Long statusId);

    WmTasks updateStatusByPerson(Long id, Long statusId, Long personId);

    WmTasks updateDevelop(Long id, Long DevelopmentId);

    void delete(Long id);

    WmTasks nSave(Long id);

    WmTasks nDelete(Long id);
}
