package com.gmail.alexey375890.service.filterService;

import com.gmail.alexey375890.dto.filterDTO.WmCompaniesFilterDTO;
import com.gmail.alexey375890.model.WmCompanies;
import com.gmail.alexey375890.repository.WmCompaniesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class WmCompaniesFilterService {

    private final List<WmCompanies> finalListOfCompanies;

    private List<WmCompanies> listOfCompanies;

    public WmCompaniesFilterService(WmCompaniesRepository wmCompaniesRepository) {
        this.finalListOfCompanies = wmCompaniesRepository.findAllCompanies();
    }

    public List<WmCompanies> filter(WmCompaniesFilterDTO filterDTO) {
        listOfCompanies = new ArrayList<>(finalListOfCompanies);

        filterByName(filterDTO.getName());
        filterByStatus(filterDTO.getStatusId());

        return listOfCompanies;
    }

    private void filterByName(String name) {
        if (name != null) {
            String finalName = name.trim().toLowerCase(Locale.ROOT);
            listOfCompanies = listOfCompanies.stream().filter(
                    el -> el.getName().toLowerCase(Locale.ROOT).equals(finalName)).collect(Collectors.toList());
        }
    }

    private void filterByStatus(Long statusId) {
        if (statusId != null) {
            listOfCompanies = listOfCompanies.stream().filter(
                    el -> el.getStatus().getId().equals(statusId)).collect(Collectors.toList());
        }
    }

}
