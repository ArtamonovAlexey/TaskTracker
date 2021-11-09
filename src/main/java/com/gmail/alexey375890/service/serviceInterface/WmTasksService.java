package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTasks;

public interface WmTasksService {
    WmTasks save(WmTasks wmTasks);

    void updateName(Long id, String newName);

    void updateDate(Long id, String newDate);

    void updateStatus(Long id, WmStatus wmStatus);

    void updateDevelop(Long id, WmDevelopments wmDevelopments);

    void delete(Long id);
}
