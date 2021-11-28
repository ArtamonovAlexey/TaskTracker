package com.gmail.alexey375890.service.filterService;

import com.gmail.alexey375890.dto.filterDTO.WmProjectsFilterDTO;
import com.gmail.alexey375890.model.WmProjects;
import com.gmail.alexey375890.repository.WmProjectsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class WmProjectsFilterService {

    private final List<WmProjects> finalListOfProjects;

    private List<WmProjects> listOfProjects;

    public WmProjectsFilterService(WmProjectsRepository wmProjectsRepository) {
        this.finalListOfProjects = wmProjectsRepository.findAllProjects();
    }

    public List<WmProjects> filter(WmProjectsFilterDTO filterDTO) {
        listOfProjects = new ArrayList<>(finalListOfProjects);

        filterByTitle(filterDTO.getTitle());
        filterByAuthor(filterDTO.getAuthorId());
        filterByClientCompany(filterDTO.getCompanyId());
        filterByStatus(filterDTO.getStatusId());

        return listOfProjects;
    }

    private void filterByTitle(String title) {
        if (title != null) {

            String finalTitle = title.trim().toLowerCase(Locale.ROOT);

            listOfProjects = listOfProjects.stream().filter(
                    el -> el.getTitle().toLowerCase(Locale.ROOT).equals(title)).collect(Collectors.toList());
        }
    }

    private void filterByAuthor(Long authorId) {
        if (authorId != null) {

            listOfProjects = listOfProjects.stream().filter(
                    el -> el.getAuthor().getId().equals(authorId)).collect(Collectors.toList());
        }
    }

    private void filterByClientCompany(Long companyId) {
        if (companyId != null) {

            listOfProjects = listOfProjects.stream().filter(
                    el -> el.getCompany().getId().equals(companyId)).collect(Collectors.toList());
        }
    }

    private void filterByStatus(Long statusId) {
        if (statusId != null) {

            listOfProjects = listOfProjects.stream().filter(
                    el -> el.getStatus().getId().equals(statusId)).collect(Collectors.toList());
        }
    }

}
