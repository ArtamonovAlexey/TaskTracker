package com.gmail.alexey375890.service.serviceImpl;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmTeams;
import com.gmail.alexey375890.repository.WmTeamsRepository;
import com.gmail.alexey375890.service.serviceInterface.WmTeamsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WmTeamsServiceImpl implements WmTeamsService {
    private final WmTeamsRepository wmTeamsRepository;

    public WmTeamsServiceImpl(WmTeamsRepository wmTeamsRepository) {
        this.wmTeamsRepository = wmTeamsRepository;
    }

    @Override
    public WmTeams save(WmTeams wmTeams) {
        wmTeams = wmTeamsRepository.saveAndFlush(wmTeams);

        return wmTeams;
    }

    @Override
    public void updatePerson(Long id, WmPeople newPerson) {
        WmTeams wmTeams = wmTeamsRepository.getById(id);
        wmTeams.setPerson(newPerson);

        wmTeamsRepository.saveAndFlush(wmTeams);
    }

    @Override
    public void updateTeam(Long id, WmDevelopments newDevelopment) {
        WmTeams wmTeams = wmTeamsRepository.getById(id);
        wmTeams.setTeam(newDevelopment);

        wmTeamsRepository.saveAndFlush(wmTeams);
    }

    @Override
    public void updateStartDate(Long id, String newStartDate) {
        WmTeams wmTeams = wmTeamsRepository.getById(id);
        wmTeams.setStartDate(newStartDate);

        wmTeamsRepository.saveAndFlush(wmTeams);
    }

    @Override
    public void updateEndDate(Long id, String newEndDate) {
        WmTeams wmTeams = wmTeamsRepository.getById(id);
        wmTeams.setEndDate(newEndDate);

        wmTeamsRepository.saveAndFlush(wmTeams);
    }

    @Override
    public void delete(Long id) {
        wmTeamsRepository.deleteById(id);
    }
}
