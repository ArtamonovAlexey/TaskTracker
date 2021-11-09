package com.gmail.alexey375890.service.serviceImpl;

import com.gmail.alexey375890.dto.WmDevelopmentsDTO;
import com.gmail.alexey375890.mapper.WmDevelopmentsMapper;
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

    private final WmDevelopmentsMapper wmDevelopmentsMapper;
    public WmDevelopmentsServiceImpl(WmDevelopmentsRepository wmDevelopmentsRepository,
                                     WmDevelopmentsMapper wmDevelopmentsMapper) {
        this.wmDevelopmentsRepository = wmDevelopmentsRepository;
        this.wmDevelopmentsMapper = wmDevelopmentsMapper;
    }

    @Override
    public WmDevelopments save(WmDevelopmentsDTO wmDevelopmentsDTO) {
        WmDevelopments wmDevelopments = wmDevelopmentsMapper.fromWmDevelopmentsDTO(wmDevelopmentsDTO);
        wmDevelopments = wmDevelopmentsRepository.saveAndFlush(wmDevelopments);

        return wmDevelopments;
    }

    @Override
    public WmDevelopments get(Long id) {
        return wmDevelopmentsRepository.getById(id);
    }

    @Override
    public WmDevelopments updateUpdated(Long id, WmPeople newUpdated) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
        wmDevelopments.setUpdated(newUpdated);

        return wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public WmDevelopments updateUpdateTime(Long id, String newDate) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
        wmDevelopments.setUpdateTime(newDate);

        return wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public WmDevelopments updateTracker(Long id, WmTracker newTracker) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
        wmDevelopments.setTracker(newTracker);

        return wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public WmDevelopments updateStartDate(Long id, String newStartDate) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
        wmDevelopments.setStartDate(newStartDate);

        return wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public WmDevelopments updateEndDate(Long id, String newEndDate) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
        wmDevelopments.setEndDate(newEndDate);

        return wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public WmDevelopments updateStatus(Long id, WmStatus newStatus) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
        wmDevelopments.setStatus(newStatus);

        return wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public void delete(Long id) {
        wmDevelopmentsRepository.deleteById(id);
    }
}
