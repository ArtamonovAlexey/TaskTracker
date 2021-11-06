package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.model.WmCompanies;

public interface WmCompaniesInterface {
    WmCompanies save(WmCompanies wmCompanies);

    boolean updateNameOfCompany(String newName, Long id);

    boolean deleteCompany(Long id);
}
