package com.gmail.alexey375890.service.serviceImpl;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTracker;
import com.gmail.alexey375890.repository.WmDevelopmentsRepository;
import com.gmail.alexey375890.service.serviceInterface.WmDevelopmentsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WmDevelopmentsServiceImpl implements WmDevelopmentsService {

    private final WmDevelopmentsRepository wmDevelopmentsRepository;

    public WmDevelopmentsServiceImpl(WmDevelopmentsRepository wmDevelopmentsRepository) {
        this.wmDevelopmentsRepository = wmDevelopmentsRepository;
    }

    @Override
    public WmDevelopments save(WmDevelopments wmDevelopments) {
        wmDevelopments = wmDevelopmentsRepository.saveAndFlush(wmDevelopments);

        return wmDevelopments;
    }

    @Override
    public void updateUpdated(Long id, WmPeople newUpdated) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
        wmDevelopments.setUpdated(newUpdated);

        wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public void updateUpdateTime(Long id, String newDate) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
        wmDevelopments.setUpdateTime(newDate);

        wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public void updateTracker(Long id, WmTracker newTracker) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
        wmDevelopments.setTracker(newTracker);

        wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public void updateStartTime(Long id, String newStartDate) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
        wmDevelopments.setStartDate(newStartDate);

        wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public void updateEndDate(Long id, String newEndDate) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
        wmDevelopments.setEndDate(newEndDate);

        wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public void updateStatus(Long id, WmStatus newStatus) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
        wmDevelopments.setStatus(newStatus);

        wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public void delete(Long id) {
        wmDevelopmentsRepository.deleteById(id);
    }
}
