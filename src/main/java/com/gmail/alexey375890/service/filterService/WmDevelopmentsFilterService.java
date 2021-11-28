package com.gmail.alexey375890.service.filterService;

import com.gmail.alexey375890.dto.filterDTO.WmDevelopmentsFilterDTO;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.repository.WmDevelopmentsRepository;
import com.gmail.alexey375890.util.RefactoringDateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WmDevelopmentsFilterService {

    private final List<WmDevelopments> finalListOfDevelopments;

    private List<WmDevelopments> listOfDevelopments;

    public WmDevelopmentsFilterService(WmDevelopmentsRepository wmDevelopmentsRepository) {
        this.finalListOfDevelopments = wmDevelopmentsRepository.findAllDevelopments();
    }

    public List<WmDevelopments> filter(WmDevelopmentsFilterDTO filterDTO) {
        listOfDevelopments = new ArrayList<>(finalListOfDevelopments);

        filterByProject(filterDTO.getProjectId());
        filterByTracker(filterDTO.getTrackerId());
        filterByUpdated(filterDTO.getUpdatedId());
        filterByUpdateTime(filterDTO.getDate1(), filterDTO.getDate2());
        filterByStartDateAndEndDate(filterDTO.getStartDate(), filterDTO.getEndDate());
        filterByStatus(filterDTO.getStatusId());

        return listOfDevelopments;
    }

    private void filterByProject(Long projectId) {
        if (projectId != null) {

            listOfDevelopments = listOfDevelopments.stream().filter(
                    el -> el.getProject().getId().equals(projectId)).collect(Collectors.toList());
        }
    }

    private void filterByUpdated(Long updatedId) {
        if (updatedId != null) {

            listOfDevelopments = listOfDevelopments.stream().filter(
                    el -> el.getUpdated().getId().equals(updatedId)).collect(Collectors.toList());
        }
    }

    private void filterByUpdateTime(String date1, String date2) {
        if (date1 != null) {
            listOfDevelopments = listOfDevelopments.stream().filter(
                    el -> RefactoringDateUtil.before(date1, el.getUpdateTime())).collect(Collectors.toList());
        }

        if (date2 != null) {
            listOfDevelopments = listOfDevelopments.stream().filter(
                    el -> RefactoringDateUtil.before(el.getUpdateTime(), date2)).collect(Collectors.toList());
        }
    }

    private void filterByTracker(Long trackerId) {
        if (trackerId != null) {
            listOfDevelopments = listOfDevelopments.stream().filter(
                    el -> el.getTracker().getId().equals(trackerId)).collect(Collectors.toList());
        }
    }

    private void filterByStartDateAndEndDate(String startDate, String endDate) {
        if (startDate != null) {
            listOfDevelopments = listOfDevelopments.stream().filter(
                    el -> RefactoringDateUtil.before(startDate, el.getStartDate())).collect(Collectors.toList());
        }

        if (endDate != null) {
            listOfDevelopments = listOfDevelopments.stream().filter(
                    el -> RefactoringDateUtil.before(el.getEndDate(), endDate)).collect(Collectors.toList());
        }
    }

    private void filterByStatus(Long statusId) {
        if (statusId != null) {
            listOfDevelopments = listOfDevelopments.stream().filter(
                    el -> el.getStatus().getId().equals(statusId)).collect(Collectors.toList());
        }
    }
}
