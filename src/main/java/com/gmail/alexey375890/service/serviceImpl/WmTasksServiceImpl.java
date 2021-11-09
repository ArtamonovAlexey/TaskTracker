package com.gmail.alexey375890.service.serviceImpl;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTasks;
import com.gmail.alexey375890.repository.WmTasksRepository;
import com.gmail.alexey375890.service.serviceInterface.WmTasksService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WmTasksServiceImpl implements WmTasksService {
    private final WmTasksRepository wmTasksRepository;

    public WmTasksServiceImpl(WmTasksRepository wmTasksRepository) {
        this.wmTasksRepository = wmTasksRepository;
    }

    @Override
    public WmTasks save(WmTasks wmTasks) {
        wmTasks = wmTasksRepository.saveAndFlush(wmTasks);

        return wmTasks;
    }

    @Override
    public void updateName(Long id, String newName) {
        WmTasks wmTasks = wmTasksRepository.getById(id);
        wmTasks.setName(newName);

        wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public void updateDate(Long id, String newDate) {
        WmTasks wmTasks = wmTasksRepository.getById(id);
        wmTasks.setDate(newDate);

        wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public void updateStatus(Long id, WmStatus newStatus) {
        WmTasks wmTasks = wmTasksRepository.getById(id);
        wmTasks.setStatus(newStatus);

        wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public void updateDevelop(Long id, WmDevelopments newDevelopment) {
        WmTasks wmTasks = wmTasksRepository.getById(id);
        wmTasks.setWmDevelopments(newDevelopment);

        wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public void delete(Long id) {
        wmTasksRepository.deleteById(id);
    }
}
