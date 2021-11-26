package com.gmail.alexey375890.service.serviceImpl.ofTable;

import com.gmail.alexey375890.model.WmUsers;
import com.gmail.alexey375890.repository.WmUsersRepository;
import com.gmail.alexey375890.service.serviceInterface.ofTable.WmUsersService;
import org.springframework.stereotype.Service;

@Service
public class WmUsersServiceImpl implements WmUsersService {

    private final WmUsersRepository wmUsersRepository;

    public WmUsersServiceImpl(WmUsersRepository wmUsersRepository) {
        this.wmUsersRepository = wmUsersRepository;
    }


    @Override
    public WmUsers save(Long userId) {
        WmUsers user = wmUsersRepository.getById(userId);

        return user;
    }

    @Override
    public WmUsers get(Long userId) {
        return wmUsersRepository.getById(userId);
    }

    @Override
    public void delete(Long userId) {
        wmUsersRepository.deleteById(userId);
    }
}
