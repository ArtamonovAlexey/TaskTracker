package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.model.WmPeople;

public interface WmPeopleService {
    WmPeople save(WmPeople wmPeople);

    void updateSurname(Long id, String newSurname);

    void updateFirstName(Long id, String newFirstName);

    void updateSecondName(Long id, String newSecondName);

    void delete(Long id);
}
