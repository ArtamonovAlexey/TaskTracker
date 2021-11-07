package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmHistoryOfProjectsChanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WmHistoryOfProjectsChangesRepository extends JpaRepository<WmHistoryOfProjectsChanges, Long> {
    Optional<WmHistoryOfProjectsChanges> findById(Long id);

    WmHistoryOfProjectsChanges getById(Long id);
}
