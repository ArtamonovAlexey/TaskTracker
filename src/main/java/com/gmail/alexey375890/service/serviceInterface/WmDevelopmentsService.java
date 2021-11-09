package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.dto.WmDevelopmentsDTO;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTracker;

public interface WmDevelopmentsService {
    WmDevelopments save(WmDevelopmentsDTO develop);

    WmDevelopments get(Long id);

    WmDevelopments updateUpdated(Long id, WmPeople newUpdated);

    WmDevelopments updateUpdateTime(Long id, String newDate);

    WmDevelopments updateTracker(Long id, WmTracker newTracker);

    WmDevelopments updateStartDate(Long id, String newStartDate);

    WmDevelopments updateEndDate(Long id, String newEndDate);

    WmDevelopments updateStatus(Long id, WmStatus newStatus);

    void delete(Long id);
}
