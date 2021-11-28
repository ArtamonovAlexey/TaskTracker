package com.gmail.alexey375890.service.filterService;

import com.gmail.alexey375890.dto.filterDTO.WmTeamsFilterDTO;
import com.gmail.alexey375890.model.WmTeams;
import com.gmail.alexey375890.repository.WmTeamsRepository;
import com.gmail.alexey375890.util.RefactoringDateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WmTeamsFilterService {

    private final List<WmTeams> finalListOfTeams;

    private List<WmTeams> listOfTeams;

    public WmTeamsFilterService(WmTeamsRepository wmTeamsRepository) {
        this.finalListOfTeams = wmTeamsRepository.findAllTeams();
    }

    public List<WmTeams> filter(WmTeamsFilterDTO filterDTO) {
        listOfTeams = new ArrayList<>(finalListOfTeams);

        filterByPerson(filterDTO.getPersonId());
        filterByTeam(filterDTO.getDevelopId());
        filterByStartDateAndEndDate(filterDTO.getStartDate(), filterDTO.getEndDate());
        filterByStatus(filterDTO.getStatusId());

        return listOfTeams;
    }

    private void filterByPerson(Long personId) {
        if (personId != null) {
            listOfTeams = listOfTeams.stream().filter(
                    el -> el.getPerson().getId().equals(personId)).collect(Collectors.toList());
        }
    }

    private void filterByTeam(Long developId) {
        if (developId != null) {
            listOfTeams = listOfTeams.stream().filter(
                    el -> el.getTeam().getId().equals(developId)).collect(Collectors.toList());
        }
    }

    private void filterByStartDateAndEndDate(String startDate, String endDate) {
        if (startDate != null) {
            listOfTeams = listOfTeams.stream().filter(
                    el -> RefactoringDateUtil.before(startDate, el.getStartDate())).collect(Collectors.toList());
        }

        if (endDate != null) {
            listOfTeams = listOfTeams.stream().filter(
                    el -> RefactoringDateUtil.before(el.getEndDate(), endDate)).collect(Collectors.toList());
        }
    }

    private void filterByStatus(Long statusId) {
        if (statusId != null) {
            listOfTeams = listOfTeams.stream().filter(
                    el -> el.getStatus().getId().equals(statusId)).collect(Collectors.toList());
        }
    }

}
