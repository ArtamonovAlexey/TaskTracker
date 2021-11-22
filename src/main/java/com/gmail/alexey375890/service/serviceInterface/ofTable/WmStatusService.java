package com.gmail.alexey375890.service.serviceInterface.ofTable;

import com.gmail.alexey375890.model.WmStatus;

public interface WmStatusService {

    WmStatus get(Long id);

    WmStatus getDoneStatus();

    WmStatus getInProgressStatus();

    WmStatus getBacklogStatus();

    WmStatus getActiveStatus();

    WmStatus getNotActiveStatus();
}
