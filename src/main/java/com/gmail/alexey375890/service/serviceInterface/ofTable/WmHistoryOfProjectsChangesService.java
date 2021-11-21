package com.gmail.alexey375890.service.serviceInterface.ofTable;

import com.gmail.alexey375890.dto.WmHistoryOfProjectsChangesDTO;
import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;

public interface WmHistoryOfProjectsChangesService {

    WmHistoryOfProjectsChanges save(WmHistoryOfProjectsChangesDTO HistoryOfProjectChanges);

    WmHistoryOfProjectsChanges get(Long id);

    WmHistoryOfProjectsChanges updateNumber(Long id, Long newProjectId);

//    WmHistoryOfProjectsChanges updateDevelop(Long id, List<WmDevelopments> newDevelop);

    WmHistoryOfProjectsChanges updateStartDate(Long id, String newStartDate);

    WmHistoryOfProjectsChanges updateEndDate(Long id, String newEndDate);

    WmHistoryOfProjectsChanges updateResponCompany(Long id, Long newResponCompanyId);

    WmHistoryOfProjectsChanges updateResponOfClientCompany(Long id, Long newResponOfClientCompanyId);

    void delete(Long id);

    WmHistoryOfProjectsChanges nSave(Long id);

    WmHistoryOfProjectsChanges nDelete(Long id);
}
