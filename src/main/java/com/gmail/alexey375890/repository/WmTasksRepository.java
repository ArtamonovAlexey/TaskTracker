package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WmTasksRepository extends JpaRepository<WmTasks, Long> {

    @Query("select wt from WmTasks wt where wt.id = :id")
    WmTasks getById(Long id);
}
