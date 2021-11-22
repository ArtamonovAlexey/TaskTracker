package com.gmail.alexey375890.mapper;

import com.gmail.alexey375890.dto.WmHistoryOfProjectsChangesDTO;
import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import org.mapstruct.Mapper;

//@Component
@Mapper(componentModel = "spring")
public interface WmHistoryOfProjectsChangesMapper {
    WmHistoryOfProjectsChanges fromWmHistoryOfProjectsChangesDTO(WmHistoryOfProjectsChangesDTO wmHistoryOfProjectsChangesDTO);

    WmHistoryOfProjectsChangesDTO toWmHistoryOfProjectsChangesDTO(WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges);
}
