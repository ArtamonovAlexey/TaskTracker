package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WmTrackerRepository extends JpaRepository<WmTracker, Long> {

    @Query("select wt from WmTracker wt where wt.id = :id")
    WmTracker getById(Long id);

    @Query("select wt from WmTracker wt where wt.id = 10")
    WmTracker getBackendRework();

    @Query("select wt from WmTracker wt where wt.id = 20")
    WmTracker getBackendDevelopment();

    @Query("select wt from WmTracker wt where wt.id = 30")
    WmTracker getFrontendRework();

    @Query("select wt from WmTracker wt where wt.id = 40")
    WmTracker getFrontendDevelopment();

    @Query("select wt from WmTracker wt where wt.id = 50")
    WmTracker getQa();

    @Query("select wt from WmTracker wt")
    List<WmTracker> findAllTrackers();
}
