package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WmTrackerRepository extends JpaRepository<WmTracker, Long> {
    Optional<WmTracker> findById(Long id);

    WmTracker getById(Long id);
}
