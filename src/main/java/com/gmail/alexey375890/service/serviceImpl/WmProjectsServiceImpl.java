package com.gmail.alexey375890.service.serviceImpl;

import com.gmail.alexey375890.model.WmCompanies;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmProjects;
import com.gmail.alexey375890.repository.WmProjectsRepository;
import com.gmail.alexey375890.service.serviceInterface.WmProjectsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WmProjectsServiceImpl implements WmProjectsService {
    private final WmProjectsRepository wmProjectsRepository;

    public WmProjectsServiceImpl(WmProjectsRepository wmProjectsRepository) {
        this.wmProjectsRepository = wmProjectsRepository;
    }

    @Override
    public WmProjects save(WmProjects wmProjects) {
        return wmProjectsRepository.saveAndFlush(wmProjects);
    }

    @Override
    public WmProjects get(Long id) {
        return wmProjectsRepository.getById(id);
    }

    @Override
    public WmProjects updateTitle(Long id, String newTitle) {
        WmProjects wmProjects = wmProjectsRepository.getById(id);
        wmProjects.setTitle(newTitle);

        return wmProjectsRepository.saveAndFlush(wmProjects);
    }

    @Override
    public WmProjects updateAuthor(Long id, WmPeople newAuthor) {
        WmProjects wmProjects = wmProjectsRepository.getById(id);
        wmProjects.setAuthor(newAuthor);

        return wmProjectsRepository.saveAndFlush(wmProjects);
    }

    @Override
    public WmProjects updateCompany(Long id, WmCompanies newCompany) {
        WmProjects wmProjects = wmProjectsRepository.getById(id);
        wmProjects.setCompany(newCompany);

        return wmProjectsRepository.saveAndFlush(wmProjects);
    }

    @Override
    public void delete(Long id) {
        wmProjectsRepository.deleteById(id);
    }
}
