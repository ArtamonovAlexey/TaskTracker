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
//        System.out.println(wmCompanies + "111");
        return wmCompaniesRepository.save(wmCompanies);
    }

    @Override
    public boolean updateNameOfCompany(String newName, Long id) {

        return true;
    }

    @Override
    public boolean deleteCompany(Long id) {

        return true;
    }
}
