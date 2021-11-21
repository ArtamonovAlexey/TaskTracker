package com.gmail.alexey375890.service.serviceImpl.ofTable;

import com.gmail.alexey375890.dto.WmTeamsDTO;
import com.gmail.alexey375890.mapper.WmTeamsMapper;
import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.model.WmTeams;
import com.gmail.alexey375890.repository.WmDevelopmentsRepository;
import com.gmail.alexey375890.repository.WmPeopleRepository;
import com.gmail.alexey375890.repository.WmStatusRepository;
import com.gmail.alexey375890.repository.WmTeamsRepository;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmTeamsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WmTeamsServiceImpl implements WmTeamsService {
    private final WmTeamsRepository wmTeamsRepository;
    private final WmStatusRepository wmStatusRepository;
    private final WmDevelopmentsRepository wmDevelopmentsRepository;
    private final WmPeopleRepository wmPeopleRepository;

    private final WmTeamsMapper wmTeamsMapper;

    public WmTeamsServiceImpl(WmTeamsRepository wmTeamsRepository,
                              WmStatusRepository wmStatusRepository,
                              WmDevelopmentsRepository wmDevelopmentsRepository,
                              WmPeopleRepository wmPeopleRepository,
                              WmTeamsMapper wmTeamsMapper
    ) {
        this.wmTeamsRepository = wmTeamsRepository;
        this.wmStatusRepository = wmStatusRepository;
        this.wmDevelopmentsRepository = wmDevelopmentsRepository;
        this.wmPeopleRepository = wmPeopleRepository;
        this.wmTeamsMapper = wmTeamsMapper;
    }

    @Override
    public WmTeams save(WmTeamsDTO wmTeamsDTO) {
        WmTeams wmTeams = wmTeamsMapper.fromWmTeamsDTO(wmTeamsDTO);

        Long personId = wmTeamsDTO.getPersonId();
        wmTeams.setPerson(wmPeopleRepository.getById(personId));

        Long teamId = wmTeamsDTO.getTeamId();
        wmTeams.setTeam(wmDevelopmentsRepository.getById(teamId));

        wmTeams.setStatus(wmStatusRepository.getActive());

        return wmTeamsRepository.saveAndFlush(wmTeams);
    }

    @Override
    public WmTeams get(Long id) {
        return wmTeamsRepository.getById(id);
    }

    @Override
    public WmTeams updatePerson(Long id, Long newPersonId) {
        WmTeams wmTeams = wmTeamsRepository.getById(id);

        WmPeople wmPeople = wmPeopleRepository.getById(newPersonId);
        wmTeams.setPerson(wmPeople);

        return wmTeamsRepository.saveAndFlush(wmTeams);
    }

    @Override
    public WmTeams updateTeam(Long id, Long newDevelopmentId) {
        WmTeams wmTeams = wmTeamsRepository.getById(id);

        WmDevelopments wmDevelopments= wmDevelopmentsRepository.getById(newDevelopmentId);
        wmTeams.setTeam(wmDevelopments);

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

    @Override
    public WmTeams nSave(Long id) {
        WmTeams wmTeams = wmTeamsRepository.getById(id);

        if (wmTeams.getStatus().equals(wmStatusRepository.getNotActive())) {
            wmTeams.setStatus(wmStatusRepository.getActive());
        }

        return wmTeams;
    }

    @Override
    public WmTeams nDelete(Long id) {
        WmTeams wmTeams = wmTeamsRepository.getById(id);

        if (wmTeams.getStatus().equals(wmStatusRepository.getActive())) {
            wmTeams.setStatus(wmStatusRepository.getNotActive());
        }

        return wmTeams;
    }
}
