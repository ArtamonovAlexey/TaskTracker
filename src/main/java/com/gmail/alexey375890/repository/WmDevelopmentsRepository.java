package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmStatus;
import com.gmail.alexey375890.model.WmTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WmDevelopmentsRepository extends JpaRepository<WmDevelopments, Long> {

    @Query("select wd from WmDevelopments wd where wd.id = :id")
    WmDevelopments getById(Long id);

    @Query("select wt from WmTasks wt where wt.develop.id = :id")
    List<WmTasks> findAllTasksById(Long id);

    @Query("select wt from WmTasks wt where wt.develop.id = :id and wt.status.id <> 120")
    List<WmTasks> findTasksById(Long id);

    @Query("select wt.status from WmTasks wt where wt.develop.id = :id and wt.status.id <> 120")
    List<WmStatus> findStatusOfTasksById(Long id);
}
