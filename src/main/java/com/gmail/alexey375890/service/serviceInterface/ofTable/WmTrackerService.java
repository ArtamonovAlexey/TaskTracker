package com.gmail.alexey375890.service.serviceInterface.ofTable;

import com.gmail.alexey375890.model.WmTracker;

public interface WmTrackerService {

    WmTracker get(Long id);

    WmTracker getBackendReworkTracker();

    WmTracker getBackendDevelopmentTracker();

    WmTracker getFrontendReworkTracker();

    WmTracker getFrontendDevelopmentTracker();

    WmTracker getQaTracker();
}
