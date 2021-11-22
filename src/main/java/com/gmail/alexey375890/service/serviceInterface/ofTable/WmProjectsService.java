package com.gmail.alexey375890.service.serviceInterface.ofTable;

import com.gmail.alexey375890.dto.WmProjectsDTO;
import com.gmail.alexey375890.model.WmProjects;

public interface WmProjectsService {
    WmProjects save(WmProjectsDTO newProjectDTO);

    WmProjects get(Long id);

    WmProjects updateTitle(Long id, String newTitle);

    WmProjects updateAuthor(Long id, Long authorId);

    WmProjects updateCompany(Long id, Long companyId);

    void delete(Long id);

    WmProjects nSave(Long id);

    WmProjects nDelete(Long id);
}
