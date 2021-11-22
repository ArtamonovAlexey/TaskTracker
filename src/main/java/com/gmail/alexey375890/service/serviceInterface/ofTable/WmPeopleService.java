package com.gmail.alexey375890.service.serviceInterface.ofTable;

import com.gmail.alexey375890.dto.WmPeopleDTO;
import com.gmail.alexey375890.model.WmPeople;

public interface WmPeopleService {
    WmPeople save(WmPeopleDTO person);

    WmPeople get(Long id);

    WmPeople updateSurname(Long id, String newSurname);

    WmPeople updateFirstName(Long id, String newFirstName);

    WmPeople updateSecondName(Long id, String newSecondName);

    void delete(Long id);

    WmPeople nSave(Long id);

    WmPeople nDelete(Long id);
}
