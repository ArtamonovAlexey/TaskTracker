package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmDevelopments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WmDevelopmentsRepository extends JpaRepository<WmDevelopments, Long> {
    Optional<WmDevelopments> findById(Long id);

    WmDevelopments getById(Long id);
}
