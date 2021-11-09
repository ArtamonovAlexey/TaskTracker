package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.dto.WmTasksDTO;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTasks;

public interface WmTasksService {
    WmTasks save(WmTasksDTO task);

    WmTasks get(Long id);

    WmTasks updateName(Long id, String newName);

    WmTasks updateDate(Long id, String newDate);

    WmTasks updateStatus(Long id, WmStatus newStatus);

    WmTasks updateDevelop(Long id, WmDevelopments newDevelopment);

    void delete(Long id);
}
