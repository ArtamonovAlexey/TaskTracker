package com.gmail.alexey375890.mapper;

import com.gmail.alexey375890.dto.WmProjectsDTO;
import com.gmail.alexey375890.model.WmProjects;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface WmProjectsMapper {
    WmProjects fromWmProjectsDTO(WmProjectsDTO wmProjectsDTO);

    WmProjectsDTO toWmProjectsDTO(WmProjects wmProjects);
}
