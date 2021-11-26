package com.gmail.alexey375890.service.serviceImpl.updating;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTasks;
import com.gmail.alexey375890.repository.WmDevelopmentsRepository;
import com.gmail.alexey375890.repository.WmHistoryOfProjectsChangesRepository;
import com.gmail.alexey375890.repository.WmStatusRepository;
import com.gmail.alexey375890.repository.WmTasksRepository;
import com.gmail.alexey375890.service.serviceInterface.updating.UpdatingDevelopmentsService;
import com.gmail.alexey375890.util.RefactoringDateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UpdatingDevelopmentsServiceImpl implements UpdatingDevelopmentsService {

    private final WmTasksRepository wmTasksRepository;
    private final WmDevelopmentsRepository wmDevelopmentsRepository;
    private final WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository;
    private final WmStatusRepository wmStatusRepository;

    public UpdatingDevelopmentsServiceImpl(WmTasksRepository wmTasksRepository,
                                           WmDevelopmentsRepository wmDevelopmentsRepository,
                                           WmHistoryOfProjectsChangesRepository wmHistoryOfProjectsChangesRepository,
                                           WmStatusRepository wmStatusRepository) {
        this.wmTasksRepository = wmTasksRepository;
        this.wmDevelopmentsRepository = wmDevelopmentsRepository;
        this.wmHistoryOfProjectsChangesRepository = wmHistoryOfProjectsChangesRepository;
        this.wmStatusRepository = wmStatusRepository;
    }

    @Override
    public void updating(Long developId) {
        if (checkOnDoneDevelop(developId)) {
            WmStatus done = wmStatusRepository.getDone();

            updatingStatusOfTasksAndDevelopByDevelopId(developId, done);
        } else if (checkOnBackLogDevelop(developId)) {
           WmStatus backlog = wmStatusRepository.getBacklog();

            updatingStatusOfTasksAndDevelopByDevelopId(developId, backlog);
       }

    }

    protected boolean checkOnBackLogDevelop(Long developId) {
        WmDevelopments wmDevelopments = wmDevelopmentsRepository.getById(developId);

        String endDate = wmDevelopments.getEndDate();

        String nowDate = RefactoringDateUtil.getNowDateAsString();

        if (!RefactoringDateUtil.before(nowDate, endDate)) {
            List<WmTasks> tasks = wmTasksRepository.findTasksByDevelopId(developId);

            tasks.forEach(task -> {
                if ((task.getStatus().equals(wmStatusRepository.getActive()))
                        || (task.getStatus().equals(wmStatusRepository.getInProgress()))) {

                    WmStatus backlog = wmStatusRepository.getBacklog();
                    task.setStatus(backlog);
                }
            });

            return true;
        }

        return false;
    }

    protected boolean checkOnDoneDevelop(Long developId) {
        List<WmTasks> tasks = wmTasksRepository.findTasksByDevelopId(developId);

        for (WmTasks task: tasks) {
            if (!task.getStatus().equals(wmStatusRepository.getDone())) {
                return false;
            }
        }

        return true;
    }

    @Transactional
    protected void updatingStatusOfTasksAndDevelopByDevelopId(Long developId, WmStatus status) {
        List<WmTasks> tasks = wmTasksRepository.findTasksByDevelopId(developId);

        tasks.forEach(task -> {
            task.setStatus(status);

            wmTasksRepository.saveAndFlush(task);
        });

        WmDevelopments develop = wmDevelopmentsRepository.getById(developId);
        develop.setStatus(status);

        wmDevelopmentsRepository.saveAndFlush(develop);
    }



//
//    @Override
//    @Transactional
//    public boolean checkOnBackLogProject(Long projectId) {
//        WmHistoryOfProjectsChanges wmHistoryOfProjectsChanges = wmHistoryOfProjectsChangesRepository.getById(projectId);
//
//        String endDate = wmHistoryOfProjectsChanges.getEndDate();
//
//        String nowDate = RefactoringDateUtil.getNowDateAsString();
//
//        if (!RefactoringDateUtil.before(nowDate, endDate)) {
//            List<WmDevelopments> list = wmHistoryOfProjectsChangesRepository.findDevelopmentsById(projectId);
//
//            list.forEach(x -> {
//                if ((x.getStatus().equals(wmStatusRepository.getActive()))
//                        || (x.getStatus().equals(wmStatusRepository.getInProgress()))) {
//
//                    WmStatus wmStatus = wmStatusRepository.getBacklog();
//
//                    x.setStatus(wmStatus);
//
//                    wmDevelopmentsRepository.saveAndFlush(x);
//                }
//            });
//
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public boolean checkOnDoneProject(Long projectId) {
//        List<WmDevelopments> list = wmHistoryOfProjectsChangesRepository.findDevelopmentsById(projectId);
//
//        boolean b = true;
//
//        for (WmDevelopments w: list) {
//            if (!w.getStatus().equals(wmStatusRepository.getDone())) {
//                b = false;
//                break;
//            }
//        }
//
//        return b;
//    }
}
