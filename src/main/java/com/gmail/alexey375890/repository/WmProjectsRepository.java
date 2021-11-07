package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmProjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WmProjectsRepository extends JpaRepository<WmProjects, Long> {
    Optional<WmProjects> findById(Long id);

    WmProjects getById(Long id);
}
