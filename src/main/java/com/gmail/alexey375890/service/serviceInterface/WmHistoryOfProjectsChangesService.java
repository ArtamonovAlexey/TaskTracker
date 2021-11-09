package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmProjects;

import java.util.List;

public interface WmHistoryOfProjectsChangesService {
    WmHistoryOfProjectsChanges save(WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges);

    void updateNumber(Long id, WmProjects wmProjects);

    void updateDevelop(Long id, List<WmDevelopments> wmDevelopments);

    void updateStartDate(Long id, String newStartDate);

    void updateEndDate(Long id, String endDate);

    void updateResponCompany(Long id, WmPeople wmPeople);

    void updateResponOfClientCompany(Long id, WmPeople wmPeople);

    void delete(Long id);
}
