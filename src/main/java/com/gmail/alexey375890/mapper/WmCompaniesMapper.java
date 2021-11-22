package com.gmail.alexey375890.mapper;

import com.gmail.alexey375890.dto.WmCompaniesDTO;
import com.gmail.alexey375890.model.WmCompanies;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface WmCompaniesMapper {
    WmCompanies fromWmCompaniesDTO(WmCompaniesDTO wmCompaniesDTO);

    WmCompaniesDTO toWmCompaniesDTO(WmCompanies wmCompanies);
}
