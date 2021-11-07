package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WmStatusRepository extends JpaRepository<WmStatus, Long> {
    Optional<WmStatus> findById(Long id);

    WmStatus getById(Long id);
}
