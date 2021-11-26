package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WmTasksRepository extends JpaRepository<WmTasks, Long> {

    @Query("select wt from WmTasks wt where wt.id = :id")
    WmTasks getById(Long id);

    @Query("select wt from WmTasks wt")
    List<WmTasks> findAllTasks();

    @Query("select wt from WmTasks wt where wt.status.id = :statusId")
    List<WmTasks> findTasksByStatusId(Long statusId);

    @Query("select wt from WmTasks wt where wt.develop.id = :developId")
    List<WmTasks> findTasksByDevelopId(Long developId);

    @Query("select wt from WmTasks wt where wt.develop.id = :developId and wt.status.id = :statusOfTasksId")
    List<WmTasks> findTasksByDevelopIdAndStatusId(Long developId, Long statusOfTasksId);

}
