package com.gmail.alexey375890.mapper;

import com.gmail.alexey375890.dto.WmDevelopmentsDTO;
import com.gmail.alexey375890.model.WmDevelopments;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface WmDevelopmentsMapper {
    WmDevelopments fromWmDevelopmentsDTO(WmDevelopmentsDTO wmDevelopmentsDTO);

    WmDevelopmentsDTO toWmDevelopmentsDTO(WmDevelopments wmDevelopments);
}
