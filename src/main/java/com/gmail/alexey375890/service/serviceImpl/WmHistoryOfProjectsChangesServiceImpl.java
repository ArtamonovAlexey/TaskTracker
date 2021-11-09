package com.gmail.alexey375890.service.serviceImpl;

import com.gmail.alexey375890.dto.WmHistoryOfProjectsChangesDTO;
import com.gmail.alexey375890.mapper.WmHistoryOfProjectsChangesMapper;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmProjects;
import com.gmail.alexey375890.repository.WmHistoryOfProjectsChangesRepository;
import com.gmail.alexey375890.service.serviceInterface.WmHistoryOfProjectsChangesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WmHistoryOfProjectsChangesServiceImpl implements WmHistoryOfProjectsChangesService {
    private final WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository;

    private final WmHistoryOfProjectsChangesMapper wmHistoryOfProjectsChangesMapper;

    public WmHistoryOfProjectsChangesServiceImpl(WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository,
                                                 WmHistoryOfProjectsChangesMapper wmHistoryOfProjectsChangesMapper) {
        this.wmHistoryOfProjectsChangesRepository = wmHistoryOfProjectsChangesRepository;
        this.wmHistoryOfProjectsChangesMapper = wmHistoryOfProjectsChangesMapper;
    }

    @Override
    public WmHistoryOfProjectsChanges save(WmHistoryOfProjectsChangesDTO wmHistoryOfProjectsChangesDTO) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesMapper.fromWmHistoryOfProjectsChangesDTO(wmHistoryOfProjectsChangesDTO);
        return wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public WmHistoryOfProjectsChanges get(Long id) {
        return wmHistoryOfProjectsChangesRepository.getById(id);
    }

    @Override
    public WmHistoryOfProjectsChanges updateNumber(Long id, WmProjects newProject) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);
        wmHistoryOfProjectsChanges.setNumber(newProject);

        return wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public WmHistoryOfProjectsChanges updateDevelop(Long id, List<WmDevelopments> newDevelopment) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);
        wmHistoryOfProjectsChanges.setDevelop( newDevelopment);

        return wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

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
    public WmHistoryOfProjectsChanges updateResponCompany(Long id, WmPeople newResponCompany) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);
        wmHistoryOfProjectsChanges.setResponCompany(newResponCompany);

        return wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public WmHistoryOfProjectsChanges updateResponOfClientCompany(Long id, WmPeople newResponOfClientCompany) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);
        wmHistoryOfProjectsChanges.setResponOfClientCompany(newResponOfClientCompany);

        return wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public void delete(Long id) {
        wmHistoryOfProjectsChangesRepository.deleteById(id);
    }
}
