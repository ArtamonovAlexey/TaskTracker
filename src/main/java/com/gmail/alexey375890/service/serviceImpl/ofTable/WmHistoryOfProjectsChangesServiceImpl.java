package com.gmail.alexey375890.service.serviceImpl.ofTable;

import com.gmail.alexey375890.dto.WmHistoryOfProjectsChangesDTO;
import com.gmail.alexey375890.mapper.WmHistoryOfProjectsChangesMapper;
import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmProjects;
import com.gmail.alexey375890.repository.*;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmHistoryOfProjectsChangesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WmHistoryOfProjectsChangesServiceImpl implements WmHistoryOfProjectsChangesService {
    private final WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository;
    private final WmPeopleRepository wmPeopleRepository;
    private final WmStatusRepository wmStatusRepository;
    private final WmDevelopmentsRepository wmDevelopmentsRepository;
    private final WmProjectsRepository wmProjectsRepository;

    private final WmHistoryOfProjectsChangesMapper wmHistoryOfProjectsChangesMapper;

    public WmHistoryOfProjectsChangesServiceImpl(WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository,
                                                 WmPeopleRepository wmPeopleRepository,
                                                 WmStatusRepository wmStatusRepository,
                                                 WmDevelopmentsRepository wmDevelopmentsRepository,
                                                 WmProjectsRepository wmProjectsRepository,
                                                 WmHistoryOfProjectsChangesMapper wmHistoryOfProjectsChangesMapper) {
        this.wmHistoryOfProjectsChangesRepository = wmHistoryOfProjectsChangesRepository;
        this.wmPeopleRepository = wmPeopleRepository;
        this.wmStatusRepository = wmStatusRepository;
        this.wmDevelopmentsRepository = wmDevelopmentsRepository;
        this.wmProjectsRepository = wmProjectsRepository;
        this.wmHistoryOfProjectsChangesMapper = wmHistoryOfProjectsChangesMapper;
    }

    @Override
    public WmHistoryOfProjectsChanges save(WmHistoryOfProjectsChangesDTO wmHistoryOfProjectsChangesDTO) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesMapper.fromWmHistoryOfProjectsChangesDTO(wmHistoryOfProjectsChangesDTO);

        wmHistoryOfProjectsChanges.setNumber(wmProjectsRepository.getById(wmHistoryOfProjectsChangesDTO.getProjectId()));

        Long responCompanyId = wmHistoryOfProjectsChangesDTO.getResponCompanyId();
        wmHistoryOfProjectsChanges.setResponCompany(wmPeopleRepository.getById(responCompanyId));

        Long responOfClientCompanyId = wmHistoryOfProjectsChangesDTO.getResponOfClientCompanyId();
        wmHistoryOfProjectsChanges.setResponOfClientCompany(wmPeopleRepository.getById(responOfClientCompanyId));

        wmHistoryOfProjectsChanges.setStatus(wmStatusRepository.getActive());

        return wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public WmHistoryOfProjectsChanges get(Long id) {
        return wmHistoryOfProjectsChangesRepository.getById(id);
    }

    @Override
    public WmHistoryOfProjectsChanges updateNumber(Long id, Long newProjectId) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);

        WmProjects wmProjects = wmProjectsRepository.getById(newProjectId);
        wmHistoryOfProjectsChanges.setNumber(wmProjects);

        return wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

//    @Override
//    public WmHistoryOfProjectsChanges updateDevelop(Long id, List<WmDevelopments> newDevelopment) {
//        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);
//        wmHistoryOfProjectsChanges.setDevelop( newDevelopment);
//
//        return wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
//    }

    @Override
    public WmHistoryOfProjectsChanges updateStartDate(Long id, String newStartDate) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);
        wmHistoryOfProjectsChanges.setStartDate(newStartDate);

        return wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public WmHistoryOfProjectsChanges updateEndDate(Long id, String newEndDate) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);
        wmHistoryOfProjectsChanges.setEndDate(newEndDate);

        return wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public WmHistoryOfProjectsChanges updateResponCompany(Long id, Long newResponCompanyId) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);

        WmPeople wmPeople = wmPeopleRepository.getById(newResponCompanyId);
        wmHistoryOfProjectsChanges.setResponCompany(wmPeople);

        return wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public WmHistoryOfProjectsChanges updateResponOfClientCompany(Long id, Long newResponOfClientCompanyId) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);

        WmPeople wmPeople = wmPeopleRepository.getById(newResponOfClientCompanyId);
        wmHistoryOfProjectsChanges.setResponOfClientCompany(wmPeople);

        return wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public void delete(Long id) {
        wmHistoryOfProjectsChangesRepository.deleteById(id);
    }

    @Override
    public WmHistoryOfProjectsChanges nSave(Long id) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);

        if (wmHistoryOfProjectsChanges.getStatus().equals(wmStatusRepository.getNotActive())) {
            wmHistoryOfProjectsChanges.setStatus(wmStatusRepository.getActive());
        }

        return wmHistoryOfProjectsChanges;
    }

    @Override
    public WmHistoryOfProjectsChanges nDelete(Long id) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);

        if (wmHistoryOfProjectsChanges.getStatus().equals(wmStatusRepository.getActive())) {
            wmHistoryOfProjectsChanges.setStatus(wmStatusRepository.getNotActive());
        }

        return wmHistoryOfProjectsChanges;
    }
}
