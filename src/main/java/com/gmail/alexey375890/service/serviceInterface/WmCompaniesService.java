package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.model.WmCompanies;

public interface WmCompaniesService {
    WmCompanies save(WmCompanies wmCompanies);

    void updateNameOfCompany(Long id,String newName);

    void delete(Long id);
}
