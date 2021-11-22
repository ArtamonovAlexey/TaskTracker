package com.gmail.alexey375890.service.serviceInterface.ofTable;

import com.gmail.alexey375890.dto.WmDevelopmentsDTO;
import com.gmail.alexey375890.model.*;

public interface WmDevelopmentsService {
    WmDevelopments save(WmDevelopmentsDTO develop);

    WmDevelopments get(Long id);

    WmDevelopments updateProject(Long id, Long projectId);

    WmDevelopments updateUpdated(Long id, Long updatedId);

    WmDevelopments updateUpdateTime(Long id, String newDate);

    WmDevelopments updateTracker(Long id, Long trackerId);

    WmDevelopments updateStartDate(Long id, String newStartDate);

    WmDevelopments updateEndDate(Long id, String newEndDate);

//    WmDevelopments updateStatus(Long id, Long statusId);

    void delete(Long id);

    WmDevelopments nSave(Long id);

    WmDevelopments nDelete(Long id);
}
