package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmDevelopments;
import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WmHistoryOfProjectsChangesRepository extends JpaRepository<WmHistoryOfProjectsChanges, Long> {

    @Query("select whopc from WmHistoryOfProjectsChanges whopc where whopc.id = :id")
    WmHistoryOfProjectsChanges getById(Long id);

    @Query("select wd from WmDevelopments wd where wd.project.id = :projectId")
    List<WmDevelopments> findAllDevelopmentsById(Long projectId);

    @Query("select wd from WmDevelopments wd where wd.project.id = :projectId and wd.status.id <> 120")
    List<WmDevelopments> findDevelopmentsById(Long projectId);

}
