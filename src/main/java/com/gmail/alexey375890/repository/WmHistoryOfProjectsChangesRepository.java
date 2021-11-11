package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WmHistoryOfProjectsChangesRepository extends JpaRepository<WmHistoryOfProjectsChanges, Long> {

    @Query("select whopc from WmHistoryOfProjectsChanges whopc where whopc.id = :id")
    WmHistoryOfProjectsChanges getById(Long id);
}
