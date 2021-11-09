package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTracker;

public interface WmDevelopmentsService {
    WmDevelopments save(WmDevelopments wmDevelopments);

    void updateUpdated(Long id, WmPeople wmPeople);

    void updateUpdateTime(Long id, String date);

    void updateTracker(Long id, WmTracker wmTracker);

    void updateStartTime(Long id, String startDate);

    void updateEndDate(Long id, String EndDate);

    void updateStatus(Long id, WmStatus wmStatus);

    void delete(Long id);
}
