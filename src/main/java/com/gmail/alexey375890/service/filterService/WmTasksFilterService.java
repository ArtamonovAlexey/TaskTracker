package com.gmail.alexey375890.service.filterService;

import com.gmail.alexey375890.dto.filterDTO.WmTasksFilterDTO;
import com.gmail.alexey375890.model.WmTasks;
import com.gmail.alexey375890.repository.WmTasksRepository;
import com.gmail.alexey375890.util.RefactoringDateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class WmTasksFilterService {

    private final List<WmTasks> finalListOfTasks;

    private List<WmTasks> listOfTasks;

    public WmTasksFilterService(WmTasksRepository wmTasksRepository) {
        this.finalListOfTasks = wmTasksRepository.findAllTasks();
    }

    public List<WmTasks> filter(WmTasksFilterDTO filterDTO) {
        listOfTasks = new ArrayList<>(finalListOfTasks);

        filterByName(filterDTO.getName());
        filterByDate(filterDTO.getDate1(), filterDTO.getDate2());
        filterByDevelop(filterDTO.getDevelopId());
        filterByStatus(filterDTO.getStatusId());

        return listOfTasks;
    }

    private void filterByName(String name) {
        if (name != null) {

            String finalName = name.trim().toLowerCase(Locale.ROOT);
            listOfTasks = listOfTasks.stream().filter(
                    el -> el.getName().toLowerCase(Locale.ROOT).equals(finalName)).collect(Collectors.toList());
        }
    }

    private void filterByDate(String date1, String date2) {
        if (date1 != null) {
            listOfTasks = listOfTasks.stream().filter(
                    el -> RefactoringDateUtil.before(date1, el.getDate())).collect(Collectors.toList());
        }

        if (date2 != null) {
            listOfTasks = listOfTasks.stream().filter(
                    el -> RefactoringDateUtil.before(el.getDate(), date2)).collect(Collectors.toList());
        }
    }

    private void filterByDevelop(Long developId) {
        if (developId != null) {

            listOfTasks = listOfTasks.stream().filter(
                    el -> el.getDevelop().getId().equals(developId)).collect(Collectors.toList());
        }
    }

    private void filterByStatus(Long statusId) {
        if (statusId != null) {

            listOfTasks = listOfTasks.stream().filter(
                    el -> el.getStatus().getId().equals(statusId)).collect(Collectors.toList());
        }
    }

}
