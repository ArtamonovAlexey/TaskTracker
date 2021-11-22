package com.gmail.alexey375890.service.serviceImpl.ofTable;

import com.gmail.alexey375890.dto.WmDevelopmentsDTO;
import com.gmail.alexey375890.mapper.WmDevelopmentsMapper;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmTracker;
import com.gmail.alexey375890.repository.*;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmDevelopmentsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WmDevelopmentsServiceImpl implements WmDevelopmentsService {

    private final WmDevelopmentsMapper wmDevelopmentsMapper;

    private final WmStatusRepository wmStatusRepository;
    private final WmTrackerRepository wmTrackerRepository;
    private final WmPeopleRepository wmPeopleRepository;
    private final WmDevelopmentsRepository wmDevelopmentsRepository;
    private final WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository;

    public WmDevelopmentsServiceImpl(WmDevelopmentsRepository wmDevelopmentsRepository,
                                     WmDevelopmentsMapper wmDevelopmentsMapper,
                                     WmStatusRepository wmStatusRepository,
                                     WmTrackerRepository wmTrackerRepository,
                                     WmPeopleRepository wmPeopleRepository,
                                     WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository) {
        this.wmDevelopmentsRepository = wmDevelopmentsRepository;
        this.wmDevelopmentsMapper = wmDevelopmentsMapper;
        this.wmStatusRepository = wmStatusRepository;
        this.wmTrackerRepository = wmTrackerRepository;
        this.wmPeopleRepository = wmPeopleRepository;
        this.wmHistoryOfProjectsChangesRepository = wmHistoryOfProjectsChangesRepository;
    }

    @Override
    public WmDevelopments save(WmDevelopmentsDTO wmDevelopmentsDTO) {
        WmDevelopments wmDevelopments = wmDevelopmentsMapper.fromWmDevelopmentsDTO(wmDevelopmentsDTO);

        wmDevelopments.setStatus(wmStatusRepository.getActive());

        Long trackerId = wmDevelopmentsDTO.getTrackerId();
        wmDevelopments.setTracker(wmTrackerRepository.getById(trackerId));

        Long projectId = wmDevelopmentsDTO.getProjectId();
        wmDevelopments.setProject(wmHistoryOfProjectsChangesRepository.getById(projectId));

        wmDevelopments = wmDevelopmentsRepository.saveAndFlush(wmDevelopments);

        return wmDevelopments;
    }

    @Override
    public WmDevelopments get(Long id) {
        return wmDevelopmentsRepository.getById(id);
    }

    @Override
    public WmDevelopments updateProject(Long id, Long newProjectId) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);

        WmHistoryOfProjectsChanges wmProjects = wmHistoryOfProjectsChangesRepository.getById(newProjectId);
        wmDevelopments.setProject(wmProjects);

        return wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public WmDevelopments updateUpdated(Long id, Long newUpdatedId) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);

        WmPeople wmPeople = wmPeopleRepository.getById(newUpdatedId);
        wmDevelopments.setUpdated(wmPeople);

        return wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public WmDevelopments updateUpdateTime(Long id, String newDate) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
        wmDevelopments.setUpdateTime(newDate);

        return wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
    }

    @Override
    public WmDevelopments updateTracker(Long id, Long newTrackerId) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);

        WmTracker wmTracker = wmTrackerRepository.getById(newTrackerId);
        wmDevelopments.setTracker(wmTracker);

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

//    @Override
//    public WmDevelopments updateStatus(Long id, Long newStatus) {
//        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);
//        wmDevelopments.setStatus(newStatus);
//
//        return wmDevelopmentsRepository.saveAndFlush(wmDevelopments);
//    }

    @Override
    public void delete(Long id) {
        wmDevelopmentsRepository.deleteById(id);
    }

    @Override
    public WmDevelopments nSave(Long id) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);

        if (wmDevelopments.getStatus().equals(wmStatusRepository.getNotActive())) {
            wmDevelopments.setStatus(wmStatusRepository.getActive());
        }

        return wmDevelopments;
    }

    @Override
    public WmDevelopments nDelete(Long id) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(id);

        if (wmDevelopments.getStatus().equals(wmStatusRepository.getActive())) {
            wmDevelopments.setStatus(wmStatusRepository.getNotActive());
        }

        return wmDevelopments;
    }

}
