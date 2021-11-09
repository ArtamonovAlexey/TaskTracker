package com.gmail.alexey375890.service.serviceImpl;

import com.gmail.alexey375890.dto.WmTasksDTO;
import com.gmail.alexey375890.mapper.WmTasksMapper;
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

    private final WmTasksMapper wmTasksMapper;

    public WmTasksServiceImpl(WmTasksRepository wmTasksRepository, WmTasksMapper wmTasksMapper) {
        this.wmTasksRepository = wmTasksRepository;
        this.wmTasksMapper = wmTasksMapper;
    }

    @Override
    public WmTasks save(WmTasksDTO wmTasksDTO) {
        WmTasks wmTasks = wmTasksMapper.fromWmTasksDTO(wmTasksDTO);
        return wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public WmTasks get(Long id) {
        return wmTasksRepository.getById(id);
    }

    @Override
    public WmTasks updateName(Long id, String newName) {
        WmTasks wmTasks = wmTasksRepository.getById(id);
        wmTasks.setName(newName);

        return wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public WmTasks updateDate(Long id, String newDate) {
        WmTasks wmTasks = wmTasksRepository.getById(id);
        wmTasks.setDate(newDate);

        return wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public WmTasks updateStatus(Long id, WmStatus newStatus) {
        WmTasks wmTasks = wmTasksRepository.getById(id);
        wmTasks.setStatus(newStatus);

        return wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public WmTasks updateDevelop(Long id, WmDevelopments newDevelopment) {
        WmTasks wmTasks = wmTasksRepository.getById(id);
        wmTasks.setWmDevelopments(newDevelopment);

        return wmTasksRepository.saveAndFlush(wmTasks);
    }

    @Override
    public void delete(Long id) {
        wmTasksRepository.deleteById(id);
    }
}
