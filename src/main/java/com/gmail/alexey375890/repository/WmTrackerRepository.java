package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WmTrackerRepository extends JpaRepository<WmTracker, Long> {

    @Query("select wt from WmTracker wt where wt.id = :id")
    WmTracker getById(Long id);
}
