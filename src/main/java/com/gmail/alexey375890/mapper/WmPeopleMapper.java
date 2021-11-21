package com.gmail.alexey375890.mapper;

import com.gmail.alexey375890.dto.WmPeopleDTO;
import com.gmail.alexey375890.model.WmPeople;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface WmPeopleMapper {
    WmPeople fromWmPeopleDTO(WmPeopleDTO wmPeopleDTO);

    WmPeopleDTO toWmPeopleDTO(WmPeople wmPeople);
}