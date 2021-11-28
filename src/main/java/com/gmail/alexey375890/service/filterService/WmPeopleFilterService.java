package com.gmail.alexey375890.service.filterService;

import com.gmail.alexey375890.dto.filterDTO.WmPeopleFilterDTO;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.repository.WmPeopleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class WmPeopleFilterService {

    private final List<WmPeople> finalListOfPeople;

    private List<WmPeople> listOfPeople;

    public WmPeopleFilterService(WmPeopleRepository wmPeopleRepository) {
        this.finalListOfPeople = wmPeopleRepository.findAllPeople();
    }

    public List<WmPeople> filter(WmPeopleFilterDTO filterDTO) {
        listOfPeople = new ArrayList<>(finalListOfPeople);

        filterBySurname(filterDTO.getSurname());
        filterByFirstName(filterDTO.getFirstName());
        filterBySecondName(filterDTO.getSecondName());
        filterByStatus(filterDTO.getStatusId());

        return listOfPeople;
    }

    private void filterBySurname(String surname) {
        if (surname != null) {

            String finalSurname = surname.trim().toLowerCase(Locale.ROOT);
            listOfPeople = listOfPeople.stream().filter(
                    el -> el.getSurname().toLowerCase(Locale.ROOT).equals(finalSurname)).collect(Collectors.toList());
        }
    }

    private void filterByFirstName(String firstName) {
        if (firstName != null) {

            String finalFirstName = firstName.trim().toLowerCase(Locale.ROOT);
            listOfPeople = listOfPeople.stream().filter(
                    el -> el.getFirstName().toLowerCase(Locale.ROOT).equals(finalFirstName)).collect(Collectors.toList());
        }
    }

    private void filterBySecondName(String secondName) {
        if (secondName != null) {

            String finalSecondName = secondName.trim().toLowerCase(Locale.ROOT);
            listOfPeople = listOfPeople.stream().filter(
                    el -> el.getSecondName().toLowerCase(Locale.ROOT).equals(finalSecondName)).collect(Collectors.toList());
        }
    }

    private void filterByStatus(Long statusId) {
        if (statusId != null) {

            listOfPeople = listOfPeople.stream().filter(
                    el -> el.getStatus().getId().equals(statusId)).collect(Collectors.toList());
        }
    }

}
