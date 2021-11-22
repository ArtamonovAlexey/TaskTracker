package com.gmail.alexey375890.service.serviceImpl.ofTable;

import com.gmail.alexey375890.dto.WmPeopleDTO;
import com.gmail.alexey375890.mapper.WmPeopleMapper;
import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.repository.WmPeopleRepository;
import com.gmail.alexey375890.repository.WmStatusRepository;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmPeopleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WmPeopleServiceImpl implements WmPeopleService {

    private final WmPeopleRepository wmPeopleRepository;

    private final WmPeopleMapper wmPeopleMapper;

    private final WmStatusRepository wmStatusRepository;


    public WmPeopleServiceImpl(WmPeopleRepository wmPeopleRepository,
                               WmPeopleMapper wmPeopleMapper,
                               WmStatusRepository wmStatusRepository) {
        this.wmPeopleRepository = wmPeopleRepository;
        this.wmPeopleMapper = wmPeopleMapper;
        this.wmStatusRepository = wmStatusRepository;
    }

    @Override
    public WmPeople save(WmPeopleDTO wmPeopleDTO) {
        WmPeople wmPeople = wmPeopleMapper.fromWmPeopleDTO(wmPeopleDTO);

        wmPeople.setStatus(wmStatusRepository.getActive());

        return wmPeopleRepository.saveAndFlush(wmPeople);
    }

    @Override
    public WmPeople get(Long id) {
        return wmPeopleRepository.getById(id);
    }

    @Override
    public WmPeople updateSurname(Long id, String newSurname) {
        WmPeople wmPeople = wmPeopleRepository.getById(id);
        wmPeople.setSurname(newSurname);

        return wmPeopleRepository.saveAndFlush(wmPeople);
    }

    @Override
    public WmPeople updateFirstName(Long id, String newFirstName) {
        WmPeople wmPeople = wmPeopleRepository.getById(id);
        wmPeople.setFirstName(newFirstName);

        return wmPeopleRepository.saveAndFlush(wmPeople);
    }

    @Override
    public WmPeople updateSecondName(Long id, String newSecondName) {
        WmPeople wmPeople = wmPeopleRepository.getById(id);
        wmPeople.setSecondName(newSecondName);

        return wmPeopleRepository.saveAndFlush(wmPeople);
    }

    @Override
    public void delete(Long id) {
        wmPeopleRepository.deleteById(id);
    }

    @Override
    public WmPeople nSave(Long id) {
        WmPeople wmPeople = wmPeopleRepository.getById(id);

        if (wmPeople.getStatus().equals(wmStatusRepository.getNotActive())) {
            wmPeople.setStatus(wmStatusRepository.getActive());
        }

        return wmPeople;
    }

    @Override
    public WmPeople nDelete(Long id) {
        WmPeople wmPeople = wmPeopleRepository.getById(id);

        if (wmPeople.getStatus().equals(wmStatusRepository.getActive())) {
            wmPeople.setStatus(wmStatusRepository.getNotActive());
        }

        return wmPeople;
    }
}
