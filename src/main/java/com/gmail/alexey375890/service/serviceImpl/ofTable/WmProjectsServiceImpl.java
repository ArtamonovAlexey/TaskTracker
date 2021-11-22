package com.gmail.alexey375890.service.serviceImpl.ofTable;

import com.gmail.alexey375890.dto.WmProjectsDTO;
import com.gmail.alexey375890.mapper.WmProjectsMapper;
import com.gmail.alexey375890.model.WmCompanies;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmProjects;
import com.gmail.alexey375890.repository.WmCompaniesRepository;
import com.gmail.alexey375890.repository.WmPeopleRepository;
import com.gmail.alexey375890.repository.WmProjectsRepository;
import com.gmail.alexey375890.repository.WmStatusRepository;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmProjectsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WmProjectsServiceImpl implements WmProjectsService {

    private final WmProjectsRepository wmProjectsRepository;
    private final WmStatusRepository wmStatusRepository;
    private final WmCompaniesRepository wmCompaniesRepository;
    private final WmPeopleRepository wmPeopleRepository;

    private final WmProjectsMapper wmProjectsMapper;


    public WmProjectsServiceImpl(WmProjectsRepository wmProjectsRepository,
                                 WmStatusRepository wmStatusRepository,
                                 WmCompaniesRepository wmCompaniesRepository,
                                 WmPeopleRepository wmPeopleRepository,
                                 WmProjectsMapper wmProjectsMapper
    ) {
        this.wmProjectsRepository = wmProjectsRepository;
        this.wmStatusRepository = wmStatusRepository;
        this.wmCompaniesRepository = wmCompaniesRepository;
        this.wmPeopleRepository = wmPeopleRepository;
        this.wmProjectsMapper = wmProjectsMapper;
    }

    @Override
    public WmProjects save(WmProjectsDTO wmProjectsDTO) {
        WmProjects wmProjects = wmProjectsMapper.fromWmProjectsDTO(wmProjectsDTO);

        wmProjects.setStatus(wmStatusRepository.getActive());

        Long authorId = wmProjectsDTO.getAuthorId();
        wmProjects.setAuthor(wmPeopleRepository.getById(authorId));

        Long companyId = wmProjectsDTO.getClientCompanyId();
        wmProjects.setCompany(wmCompaniesRepository.getById(companyId));

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
    public WmProjects updateAuthor(Long id, Long newAuthorId) {
        WmProjects wmProjects = wmProjectsRepository.getById(id);

        WmPeople wmPeople = wmPeopleRepository.getById(newAuthorId);
        wmProjects.setAuthor(wmPeople);

        return wmProjectsRepository.saveAndFlush(wmProjects);
    }

    @Override
    public WmProjects updateCompany(Long id, Long newCompanyId) {
        WmProjects wmProjects = wmProjectsRepository.getById(id);

        WmCompanies wmCompanies = wmCompaniesRepository.getById(newCompanyId);
        wmProjects.setCompany(wmCompanies);

        return wmProjectsRepository.saveAndFlush(wmProjects);
    }

    @Override
    public void delete(Long id) {
        wmProjectsRepository.deleteById(id);
    }

    @Override
    public WmProjects nSave(Long id) {
        WmProjects wmProjects = wmProjectsRepository.getById(id);

        if (wmProjects.getStatus().equals(wmStatusRepository.getNotActive())) {
            wmProjects.setStatus(wmStatusRepository.getActive());
        }

        return wmProjects;
    }

    @Override
    public WmProjects nDelete(Long id) {
        WmProjects wmProjects = wmProjectsRepository.getById(id);

        if (wmProjects.getStatus().equals(wmStatusRepository.getActive())) {
            wmProjects.setStatus(wmStatusRepository.getNotActive());
        }

        return wmProjects;
    }
}
