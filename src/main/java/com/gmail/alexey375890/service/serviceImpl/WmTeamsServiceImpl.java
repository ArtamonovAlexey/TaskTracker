package com.gmail.alexey375890.service.serviceImpl;

import com.gmail.alexey375890.dto.WmTeamsDTO;
import com.gmail.alexey375890.mapper.WmTeamsMapper;
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

    private final WmTeamsMapper wmTeamsMapper;

    public WmTeamsServiceImpl(WmTeamsRepository wmTeamsRepository, WmTeamsMapper wmTeamsMapper) {
        this.wmTeamsRepository = wmTeamsRepository;
        this.wmTeamsMapper = wmTeamsMapper;
    }

    @Override
    public WmTeams save(WmTeamsDTO wmTeamsDTO) {
        WmTeams wmTeams = wmTeamsMapper.fromWmTeamsDTO(wmTeamsDTO);

        return wmTeamsRepository.saveAndFlush(wmTeams);
    }

    @Override
    public WmTeams get(Long id) {
        return wmTeamsRepository.getById(id);
    }

    @Override
    public WmTeams updatePerson(Long id, WmPeople newPerson) {
        WmTeams wmTeams = wmTeamsRepository.getById(id);
        wmTeams.setPerson(newPerson);

        return wmTeamsRepository.saveAndFlush(wmTeams);
    }

    @Override
    public WmTeams updateTeam(Long id, WmDevelopments newDevelopment) {
        WmTeams wmTeams = wmTeamsRepository.getById(id);
        wmTeams.setTeam(newDevelopment);

        return wmTeamsRepository.saveAndFlush(wmTeams);
    }

    @Override
    public WmTeams updateStartDate(Long id, String newStartDate) {
        WmTeams wmTeams = wmTeamsRepository.getById(id);
        wmTeams.setStartDate(newStartDate);

        return wmTeamsRepository.saveAndFlush(wmTeams);
    }

    @Override
    public WmTeams updateEndDate(Long id, String newEndDate) {
        WmTeams wmTeams = wmTeamsRepository.getById(id);
        wmTeams.setEndDate(newEndDate);

        return wmTeamsRepository.saveAndFlush(wmTeams);
    }

    @Override
    public void delete(Long id) {
        wmTeamsRepository.deleteById(id);
    }
}
