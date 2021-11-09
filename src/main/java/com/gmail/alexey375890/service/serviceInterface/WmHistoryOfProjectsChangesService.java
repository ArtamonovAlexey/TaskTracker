package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.dto.WmHistoryOfProjectsChangesDTO;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmProjects;

import java.util.List;

public interface WmHistoryOfProjectsChangesService {
    WmHistoryOfProjectsChanges save(WmHistoryOfProjectsChangesDTO HistoryOfProjectChanges);

    WmHistoryOfProjectsChanges get(Long id);

    WmHistoryOfProjectsChanges updateNumber(Long id, WmProjects newNumber);

    WmHistoryOfProjectsChanges updateDevelop(Long id, List<WmDevelopments> newDevelop);

    WmHistoryOfProjectsChanges updateStartDate(Long id, String newStartDate);

    WmHistoryOfProjectsChanges updateEndDate(Long id, String newEndDate);

    WmHistoryOfProjectsChanges updateResponCompany(Long id, WmPeople newResponCompany);

    WmHistoryOfProjectsChanges updateResponOfClientCompany(Long id, WmPeople newResponOfClientCompany);

    void delete(Long id);
}
