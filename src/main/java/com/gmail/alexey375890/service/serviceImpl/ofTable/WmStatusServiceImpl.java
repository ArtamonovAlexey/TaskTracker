package com.gmail.alexey375890.service.serviceImpl.ofTable;

import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.repository.WmStatusRepository;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmStatusService;
import org.springframework.stereotype.Service;

@Service
public class WmStatusServiceImpl implements WmStatusService {

    private final WmStatusRepository wmStatusRepository;

    public WmStatusServiceImpl(WmStatusRepository wmStatusRepository) {
        this.wmStatusRepository = wmStatusRepository;
    }

    @Override
    public WmStatus get(Long id) {
        return wmStatusRepository.getById(id);
    }

    @Override
    public WmStatus getDoneStatus() {
        return wmStatusRepository.getDone();
    }

    @Override
    public WmStatus getInProgressStatus() {
        return wmStatusRepository.getInProgress();
    }

    @Override
    public WmStatus getBacklogStatus() {
        return wmStatusRepository.getBacklog();
    }

    @Override
    public WmStatus getActiveStatus() {
        return wmStatusRepository.getActive();
    }

    @Override
    public WmStatus getNotActiveStatus() {
        return wmStatusRepository.getNotActive();
    }

}
