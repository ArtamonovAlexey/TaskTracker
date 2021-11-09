package com.gmail.alexey375890.service.serviceInterface;

import com.gmail.alexey375890.dto.WmTeamsDTO;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmTeams;

public interface WmTeamsService {
    WmTeams save(WmTeamsDTO team);

    WmTeams get(Long id);

    WmTeams updatePerson(Long id, WmPeople newPerson);

    WmTeams updateTeam(Long id, WmDevelopments newDevelop);

    WmTeams updateStartDate(Long id, String newStartDate);

    WmTeams updateEndDate(Long id, String newEndDate);

    void delete(Long id);
}
