package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.model.WmCompanies;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmProjects;

public interface WmProjectsService {
    WmProjects save(WmProjects project);

    WmProjects get(Long id);

    WmProjects updateTitle(Long id, String newTitle);

    WmProjects updateAuthor(Long id, WmPeople newAuthor);

    WmProjects updateCompany(Long id, WmCompanies newCompany);

    void delete(Long id);
}
