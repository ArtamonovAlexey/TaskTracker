package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WmHistoryOfProjectsChangesRepository extends JpaRepository<WmHistoryOfProjectsChanges, Long> {

    @Query("select whopc from WmHistoryOfProjectsChanges whopc where whopc.id = :id")
    WmHistoryOfProjectsChanges getById(Long id);

    @Query("select whopc from WmHistoryOfProjectsChanges whopc")
    List<WmHistoryOfProjectsChanges> findAllHistoryOfProjectsChanges();

    @Query("select whopc from WmHistoryOfProjectsChanges whopc where whopc.status.id = :statusId")
    List<WmHistoryOfProjectsChanges> findHistoryOfProjectsChangesByStatusId(Long statusId);

    @Query("select whopc from WmHistoryOfProjectsChanges whopc where whopc.number.id = :projectId")
    List<WmHistoryOfProjectsChanges> findFullHistoryOfProjectByProjectId(Long projectId);

    @Query("select whopc from WmHistoryOfProjectsChanges whopc " +
            "where whopc.number.id = :projectId and whopc.status.id = :statusOfProjectId")
    List<WmHistoryOfProjectsChanges> findFullHistoryOfProjectByProjectIdAndStatusId(Long projectId, Long statusOfProjectId);

}
