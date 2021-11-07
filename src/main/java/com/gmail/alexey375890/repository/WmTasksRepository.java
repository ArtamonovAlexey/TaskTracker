package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmTasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WmTasksRepository extends JpaRepository<WmTasks, Long> {
    Optional<WmTasks> findById(Long id);

    WmTasks getById(Long id);
}
