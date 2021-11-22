package com.gmail.alexey375890.service.serviceImpl.ofTable;

import com.gmail.alexey375890.dto.WmCompaniesDTO;
import com.gmail.alexey375890.mapper.WmCompaniesMapper;
import com.gmail.alexey375890.model.WmCompanies;
import com.gmail.alexey375890.repository.WmCompaniesRepository;
import com.gmail.alexey375890.repository.WmStatusRepository;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmCompaniesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WmCompaniesServiceImpl implements WmCompaniesService {

    private final WmCompaniesRepository wmCompaniesRepository;
    private final WmStatusRepository wmStatusRepository;

    private final WmCompaniesMapper wmCompaniesMapper;

    public WmCompaniesServiceImpl(WmCompaniesRepository wmCompaniesRepository,
                                  WmStatusRepository wmStatusRepository,
                                  WmCompaniesMapper wmCompaniesMapper
    ) {
        this.wmCompaniesRepository = wmCompaniesRepository;
        this.wmStatusRepository = wmStatusRepository;
        this.wmCompaniesMapper = wmCompaniesMapper;
    }

    @Override
    public WmCompanies save(WmCompaniesDTO wmCompaniesDTO) {
        WmCompanies wmCompanies = wmCompaniesMapper.fromWmCompaniesDTO(wmCompaniesDTO);
        wmCompanies.setStatus(wmStatusRepository.getActive());

        return wmCompaniesRepository.saveAndFlush(wmCompanies);
    }

    @Override
    public WmCompanies get(Long id) {
        return wmCompaniesRepository.getById(id);
    }

    @Override
    public WmCompanies updateNameOfCompany(Long id, String newName) {
        WmCompanies wmCompanies = wmCompaniesRepository.getById(id);
        wmCompanies.setName(newName);

        return wmCompaniesRepository.saveAndFlush(wmCompanies);
    }

    @Override
    public void delete(Long id) {
        wmCompaniesRepository.deleteById(id);
    }

    @Override
    public WmCompanies nSave(Long id) {
        WmCompanies wmCompanies = wmCompaniesRepository.getById(id);

        if (wmCompanies.getStatus().equals(wmStatusRepository.getNotActive())) {
            wmCompanies.setStatus(wmStatusRepository.getActive());
        }

        return wmCompanies;
    }

    @Override
    public WmCompanies nDelete(Long id) {
        WmCompanies wmCompanies = wmCompaniesRepository.getById(id);

        if (wmCompanies.getStatus().equals(wmStatusRepository.getActive())) {
            wmCompanies.setStatus(wmStatusRepository.getNotActive());
        }

        return wmCompanies;
    }
}
