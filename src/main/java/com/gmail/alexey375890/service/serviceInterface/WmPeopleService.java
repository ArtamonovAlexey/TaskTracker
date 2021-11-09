package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.model.WmPeople;

public interface WmPeopleService {
    WmPeople save(WmPeople person);

    WmPeople get(Long id);

    WmPeople updateSurname(Long id, String newSurname);

    WmPeople updateFirstName(Long id, String newFirstName);

    WmPeople updateSecondName(Long id, String newSecondName);

    void delete(Long id);
}
