package com.gmail.alexey375890.service.filterService;

import com.gmail.alexey375890.dto.filterDTO.WmHistoryOfProjectsChangesFilterDTO;
import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import com.gmail.alexey375890.repository.WmHistoryOfProjectsChangesRepository;
import com.gmail.alexey375890.util.RefactoringDateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WmHistoryOfProjectsChangesFilterService {

    private final List<WmHistoryOfProjectsChanges> finalListOfProjects;

    private List<WmHistoryOfProjectsChanges> listOfProjects;

    public WmHistoryOfProjectsChangesFilterService(WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository) {
        this.finalListOfProjects = wmHistoryOfProjectsChangesRepository.findAllHistoryOfProjectsChanges();
    }

    public List<WmHistoryOfProjectsChanges> filter(WmHistoryOfProjectsChangesFilterDTO filterDTO) {
        listOfProjects = new ArrayList<>(finalListOfProjects);

        filterByProject(filterDTO.getProjectId());
        filterByStartDateAndEndDate(filterDTO.getStartDate(), filterDTO.getEndDate());
        filterByResponCompany(filterDTO.getResponCompanyId());
        filterByResponOfClientCompany(filterDTO.getResponOfClientCompanyId());
        filterByStatus(filterDTO.getStatusId());

        return listOfProjects;
    }

    private void filterByProject(Long projectId) {
        if (projectId != null) {

            listOfProjects = listOfProjects.stream().filter(
                    el -> el.getNumber().getId().equals(projectId)).collect(Collectors.toList());
        }
    }

    private void filterByStartDateAndEndDate(String startDate, String endDate) {
        if (startDate != null) {
            listOfProjects = listOfProjects.stream().filter(
                    el -> RefactoringDateUtil.before(startDate, el.getStartDate())).collect(Collectors.toList());
        }

        if (endDate != null) {
            listOfProjects = listOfProjects.stream().filter(
                    el -> RefactoringDateUtil.before(el.getEndDate(), endDate)).collect(Collectors.toList());
        }
    }

    private void filterByResponCompany(Long responCompanyId) {
        if (responCompanyId != null) {
            listOfProjects = listOfProjects.stream().filter(
                    el -> el.getResponCompany().getId().equals(responCompanyId)).collect(Collectors.toList());
        }
    }

    private void filterByResponOfClientCompany(Long responOfClientCompanyId) {
        if (responOfClientCompanyId != null) {
            listOfProjects = listOfProjects.stream().filter(
                    el -> el.getResponOfClientCompany().getId().equals(responOfClientCompanyId)).collect(Collectors.toList());
        }
    }

    private void filterByStatus(Long statusId) {
        if (statusId != null) {
            listOfProjects = listOfProjects.stream().filter(
                    el -> el.getStatus().getId().equals(statusId)).collect(Collectors.toList());
        }
    }

}
