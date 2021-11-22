package com.gmail.alexey375890.service.serviceImpl.ofTable;

import com.gmail.alexey375890.dto.WmTasksDTO;
import com.gmail.alexey375890.mapper.WmTasksMapper;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTasks;
import com.gmail.alexey375890.repository.*;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmTasksService;
import com.gmail.alexey375890.util.RefactoringDateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WmTasksServiceImpl implements WmTasksService {
    private final WmTasksRepository wmTasksRepository;
    private final WmDevelopmentsRepository wmDevelopmentsRepository;
    private final WmStatusRepository wmStatusRepository;
    private final WmPeopleRepository wmPeopleRepository;
    private final WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository;

    private final WmTasksMapper wmTasksMapper;

    public WmTasksServiceImpl(WmTasksRepository wmTasksRepository,
                              WmDevelopmentsRepository wmDevelopmentsRepository,
                              WmStatusRepository wmStatusRepository,
                              WmPeopleRepository wmPeopleRepository,
                              WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository,
                              WmTasksMapper wmTasksMapper) {
        this.wmTasksRepository = wmTasksRepository;
        this.wmDevelopmentsRepository = wmDevelopmentsRepository;
        this.wmStatusRepository = wmStatusRepository;
        this.wmPeopleRepository = wmPeopleRepository;
        this.wmHistoryOfProjectsChangesRepository = wmHistoryOfProjectsChangesRepository;
        this.wmTasksMapper = wmTasksMapper;
    }

    @Override
    public WmTasks save(WmTasksDTO wmTasksDTO) {
        WmTasks wmTasks = wmTasksMapper.fromWmTasksDTO(wmTasksDTO);

        Long developId = wmTasksDTO.getDevelopId();
        wmTasks.setDevelop(wmDevelopmentsRepository.getById(developId));

        wmTasks.setStatus(wmStatusRepository.getActive());

        return wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public WmTasks get(Long id) {
        return wmTasksRepository.getById(id);
    }

    @Override
    public WmTasks updateName(Long id, String newName) {
        WmTasks wmTasks = wmTasksRepository.getById(id);
        wmTasks.setName(newName);

        return wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public WmTasks updateDate(Long id, String newDate) {
        WmTasks wmTasks = wmTasksRepository.getById(id);
        wmTasks.setDate(newDate);

        return wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public WmTasks updateStatus(Long id, Long newStatusId) {
        WmTasks wmTasks = wmTasksRepository.getById(id);

        WmStatus wmStatus = wmStatusRepository.getById(newStatusId);
        wmTasks.setStatus(wmStatus);

        return wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public WmTasks updateStatusByPerson(Long id, Long newStatusId, Long personId) {
        WmTasks wmTasks = wmTasksRepository.getById(id);
        WmStatus wmStatus = wmStatusRepository.getById(newStatusId);
        WmPeople wmPeople = wmPeopleRepository.getById(personId);

        String update_date = RefactoringDateUtil.getNowDateAsString();

        WmDevelopments wmDevelopments = wmTasks.getDevelop();
        wmDevelopments.setUpdated(wmPeople);
        wmDevelopments.setUpdateTime(update_date);

        wmTasks.setStatus(wmStatus);

        return wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public WmTasks updateDevelop(Long id, Long newDevelopmentId) {
        WmTasks wmTasks = wmTasksRepository.getById(id);

        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(newDevelopmentId);
        wmTasks.setDevelop(wmDevelopments);

        return wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public void delete(Long id) {
        wmTasksRepository.deleteById(id);
    }

    @Override
    public WmTasks nSave(Long id) {
        WmTasks wmTasks = wmTasksRepository.getById(id);

        if (wmTasks.getStatus().equals(wmStatusRepository.getNotActive())) {
            wmTasks.setStatus(wmStatusRepository.getActive());
        }

        return wmTasks;
    }

    @Override
    public WmTasks nDelete(Long id) {
        WmTasks wmTasks = wmTasksRepository.getById(id);

        if (wmTasks.getStatus().equals(wmStatusRepository.getActive())) {
            wmTasks.setStatus(wmStatusRepository.getNotActive());
        }

        return wmTasks;
    }
}
