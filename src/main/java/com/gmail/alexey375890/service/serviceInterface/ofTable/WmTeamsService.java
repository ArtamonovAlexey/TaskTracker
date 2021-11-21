package com.gmail.alexey375890.service.serviceInterface.ofTable;

import com.gmail.alexey375890.dto.WmTeamsDTO;
import com.gmail.alexey375890.model.WmTeams;

public interface WmTeamsService {
    WmTeams save(WmTeamsDTO team);

    WmTeams get(Long id);

    WmTeams updatePerson(Long id, Long personId);

    WmTeams updateTeam(Long id, Long teamId);

    WmTeams updateStartDate(Long id, String newStartDate);

    WmTeams updateEndDate(Long id, String newEndDate);

    void delete(Long id);

    WmTeams nSave(Long id);

    WmTeams nDelete(Long id);
}
