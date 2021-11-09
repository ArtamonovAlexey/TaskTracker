package com.gmail.alexey375890.service.serviceImpl;

import com.gmail.alexey375890.model.WmPeople;
import com.gmail.alexey375890.repository.WmPeopleRepository;
import com.gmail.alexey375890.service.serviceInterface.WmPeopleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WmPeopleServiceImpl implements WmPeopleService {
    private final WmPeopleRepository wmPeopleRepository;

    public WmPeopleServiceImpl(WmPeopleRepository wmPeopleRepository) {
        this.wmPeopleRepository = wmPeopleRepository;
    }

    @Override
    public WmPeople save(WmPeople wmPeople) {
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
}
