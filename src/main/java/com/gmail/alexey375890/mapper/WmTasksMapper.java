package com.gmail.alexey375890.mapper;

import com.gmail.alexey375890.dto.WmTasksDTO;
import com.gmail.alexey375890.model.WmTasks;
import org.mapstruct.Mapper;

//@Component
@Mapper(componentModel = "spring")
public interface WmTasksMapper {
    WmTasks fromWmTasksDTO(WmTasksDTO wmTasksDTO);

    WmTasksDTO toWmTasksDTO(WmTasks wmTasks);
}
