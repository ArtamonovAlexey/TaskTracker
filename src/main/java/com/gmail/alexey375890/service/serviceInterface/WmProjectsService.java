package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.model.WmCompanies;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmProjects;

public interface WmProjectsService {
    WmProjects save(WmProjects wmProjects);

    void updateTitle(Long id, String newTitle);

    void updateAuthor(Long id, WmPeople wmPeople);

    void updateCompany(Long id, WmCompanies wmCompanies);

    void delete(Long id);
}
