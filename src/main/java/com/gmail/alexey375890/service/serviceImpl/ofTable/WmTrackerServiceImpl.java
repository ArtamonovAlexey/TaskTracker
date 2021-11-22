package com.gmail.alexey375890.service.serviceImpl.ofTable;

import com.gmail.alexey375890.model.WmTracker;
import com.gmail.alexey375890.repository.WmTrackerRepository;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmTrackerService;
import org.springframework.stereotype.Service;

@Service
public class WmTrackerServiceImpl implements WmTrackerService {
    private final WmTrackerRepository wmTrackerRepository;

    public WmTrackerServiceImpl(WmTrackerRepository wmTrackerRepository) {
        this.wmTrackerRepository = wmTrackerRepository;
    }

    @Override
    public WmTracker get(Long id) {
        return wmTrackerRepository.getById(id);
    }

    @Override
    public WmTracker getBackendReworkTracker() {
        return wmTrackerRepository.getBackendRework();
    }

    @Override
    public WmTracker getBackendDevelopmentTracker() {
        return wmTrackerRepository.getBackendDevelopment();
    }

    @Override
    public WmTracker getFrontendReworkTracker() {
        return wmTrackerRepository.getFrontendRework();
    }

    @Override
    public WmTracker getFrontendDevelopmentTracker() {
        return wmTrackerRepository.getFrontendDevelopment();
    }

    @Override
    public WmTracker getQaTracker() {
        return wmTrackerRepository.getQa();
    }
}
