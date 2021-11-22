package com.gmail.alexey375890.service.serviceInterface.ofTable;

import com.gmail.alexey375890.dto.WmCompaniesDTO;
import com.gmail.alexey375890.model.WmCompanies;

public interface WmCompaniesService {
    WmCompanies save(WmCompaniesDTO companyDTO);

    WmCompanies get(Long id);

    WmCompanies updateNameOfCompany(Long id, String newName);

    void delete(Long id);

    WmCompanies nSave(Long id);

    WmCompanies nDelete(Long id);
}
