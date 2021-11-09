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
        wmPeople = wmPeopleRepository.saveAndFlush(wmPeople);

        return wmPeople;
    }

    @Override
    public void updateSurname(Long id, String newSurname) {
        WmPeople wmPeople = wmPeopleRepository.getById(id);
        wmPeople.setSurname(newSurname);

        wmPeopleRepository.saveAndFlush(wmPeople);
    }

    @Override
    public void updateFirstName(Long id, String newFirstName) {
        WmPeople wmPeople = wmPeopleRepository.getById(id);
        wmPeople.setFirstName(newFirstName);

        wmPeopleRepository.saveAndFlush(wmPeople);
    }

    @Override
    public void updateSecondName(Long id, String newSecondName) {
        WmPeople wmPeople = wmPeopleRepository.getById(id);
        wmPeople.setSecondName(newSecondName);

        wmPeopleRepository.saveAndFlush(wmPeople);
    }

    @Override
    public void delete(Long id) {
        wmPeopleRepository.deleteById(id);
    }
}
