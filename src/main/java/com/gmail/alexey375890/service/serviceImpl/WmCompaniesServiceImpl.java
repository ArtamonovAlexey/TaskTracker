package com.gmail.alexey375890.service.serviceImpl;

import com.gmail.alexey375890.model.WmCompanies;
import com.gmail.alexey375890.repository.WmCompaniesRepository;
import com.gmail.alexey375890.service.serviceInterface.WmCompaniesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WmCompaniesServiceImpl implements WmCompaniesService {

    private final WmCompaniesRepository wmCompaniesRepository;

    public WmCompaniesServiceImpl(WmCompaniesRepository wmCompaniesRepository) {
        this.wmCompaniesRepository = wmCompaniesRepository;
    }

    @Override
    public WmCompanies save(WmCompanies wmCompanies) {
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
}
