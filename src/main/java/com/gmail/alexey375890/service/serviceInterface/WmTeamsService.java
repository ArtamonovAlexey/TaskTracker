package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmTeams;

public interface WmTeamsService {
    WmTeams save(WmTeams wmTeams);

    void updatePerson(Long id, WmPeople wmPeople);

    void updateTeam(Long id, WmDevelopments wmDevelopments);

    void updateStartDate(Long id, String startDate);

    void updateEndDate(Long id, String endDate);

    void delete(Long id);
}
