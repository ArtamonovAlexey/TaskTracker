package com.gmail.alexey375890.service.serviceImpl;

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

    public WmHistoryOfProjectsChangesServiceImpl(WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository) {
        this.wmHistoryOfProjectsChangesRepository = wmHistoryOfProjectsChangesRepository;
    }

    @Override
    public WmHistoryOfProjectsChanges save(WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges) {
        wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);

        return wmHistoryOfProjectsChanges;
    }

    @Override
    public void updateNumber(Long id, WmProjects newProject) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);
        wmHistoryOfProjectsChanges.setNumber(newProject);

        wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public void updateDevelop(Long id, List<WmDevelopments> newDevelopment) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);
        wmHistoryOfProjectsChanges.setDevelop( newDevelopment);

        wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public void updateStartDate(Long id, String newStartDate) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);
        wmHistoryOfProjectsChanges.setStartDate(newStartDate);

        wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public void updateEndDate(Long id, String newEndDate) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);
        wmHistoryOfProjectsChanges.setEndDate(newEndDate);

        wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public void updateResponCompany(Long id, WmPeople newResponCompany) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);
        wmHistoryOfProjectsChanges.setResponCompany(newResponCompany);

        wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public void updateResponOfClientCompany(Long id, WmPeople newResponOfClientCompany) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(id);
        wmHistoryOfProjectsChanges.setResponOfClientCompany(newResponOfClientCompany);

        wmHistoryOfProjectsChangesRepository.saveAndFlush(wmHistoryOfProjectsChanges);
    }

    @Override
    public void delete(Long id) {
        wmHistoryOfProjectsChangesRepository.deleteById(id);
    }
}
