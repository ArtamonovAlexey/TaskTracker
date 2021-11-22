package com.gmail.alexey375890.mapper;

import com.gmail.alexey375890.dto.WmTeamsDTO;
import com.gmail.alexey375890.model.WmTeams;
import org.mapstruct.Mapper;

//@Component
@Mapper(componentModel = "spring")
public interface WmTeamsMapper {
    WmTeams fromWmTeamsDTO(WmTeamsDTO wmTeamsDTO);

    WmTeamsDTO toWmTeamsDTO(WmTeams wmTeams);
}
