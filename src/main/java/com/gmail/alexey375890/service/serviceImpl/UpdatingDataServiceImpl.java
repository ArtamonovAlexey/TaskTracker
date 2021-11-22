package com.gmail.alexey375890.service.serviceImpl;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTasks;
import com.gmail.alexey375890.repository.WmDevelopmentsRepository;
import com.gmail.alexey375890.repository.WmHistoryOfProjectsChangesRepository;
import com.gmail.alexey375890.repository.WmStatusRepository;
import com.gmail.alexey375890.repository.WmTasksRepository;
import com.gmail.alexey375890.service.serviceInterface.UpdatingDataService;
import com.gmail.alexey375890.util.RefactoringDateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UpdatingDataServiceImpl implements UpdatingDataService {

    private final WmTasksRepository wmTasksRepository;
    private final WmDevelopmentsRepository wmDevelopmentsRepository;
    private final WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository;
    private final WmStatusRepository wmStatusRepository;

    public UpdatingDataServiceImpl(WmTasksRepository wmTasksRepository,
                                   WmDevelopmentsRepository wmDevelopmentsRepository,
                                   WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository,
                                   WmStatusRepository wmStatusRepository) {
        this.wmTasksRepository = wmTasksRepository;
        this.wmDevelopmentsRepository = wmDevelopmentsRepository;
        this.wmHistoryOfProjectsChangesRepository = wmHistoryOfProjectsChangesRepository;
        this.wmStatusRepository = wmStatusRepository;
    }

    @Override
    @Transactional
    public boolean checkOnBackLogDevelop(Long developId) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(developId);

        String endDate = wmDevelopments.getEndDate();

        String nowDate = RefactoringDateUtil.getNowDateAsString();

        if (!RefactoringDateUtil.before(nowDate, endDate)) {
            List<WmTasks> list = wmDevelopmentsRepository.findTasksById(developId);

            list.forEach(x -> {
                if ((x.getStatus().equals(wmStatusRepository.getActive()))
                        || (x.getStatus().equals(wmStatusRepository.getInProgress()))) {

                    WmStatus wmStatus = wmStatusRepository.getBacklog();

                    x.setStatus(wmStatus);

                    wmTasksRepository.saveAndFlush(x);
                }
            });

            return true;
        }

        return false;
    }

    @Override
    public boolean checkOnDoneDevelop(Long developId) {
        List<WmTasks> list = wmDevelopmentsRepository.findTasksById(developId);

        boolean b = true;

        for (WmTasks w: list) {
            if (!w.getStatus().equals(wmStatusRepository.getDone())) {
                b = false;
                break;
            }
        }

        return b;
    }

    @Override
    @Transactional
    public boolean checkOnBackLogProject(Long projectId) {
        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(projectId);

        String endDate = wmHistoryOfProjectsChanges.getEndDate();

        String nowDate = RefactoringDateUtil.getNowDateAsString();

        if (!RefactoringDateUtil.before(nowDate, endDate)) {
            List<WmDevelopments> list = wmHistoryOfProjectsChangesRepository.findDevelopmentsById(projectId);

            list.forEach(x -> {
                if ((x.getStatus().equals(wmStatusRepository.getActive()))
                        || (x.getStatus().equals(wmStatusRepository.getInProgress()))) {

                    WmStatus wmStatus = wmStatusRepository.getBacklog();

                    x.setStatus(wmStatus);

                    wmDevelopmentsRepository.saveAndFlush(x);
                }
            });

            return true;
        }

        return false;
    }

    @Override
    public boolean checkOnDoneProject(Long projectId) {
        List<WmDevelopments> list = wmHistoryOfProjectsChangesRepository.findDevelopmentsById(projectId);

        boolean b = true;

        for (WmDevelopments w: list) {
            if (!w.getStatus().equals(wmStatusRepository.getDone())) {
                b = false;
                break;
            }
        }

        return b;
    }
}
