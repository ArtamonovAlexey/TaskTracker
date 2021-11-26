package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WmStatusRepository extends JpaRepository<WmStatus, Long> {

    @Query("select ws from WmStatus ws where ws.id = :id")
    WmStatus getById(Long id);

    @Query("select ws from WmStatus ws where ws.id = 10")
    WmStatus getDone();

    @Query("select ws from WmStatus ws where ws.id = 20")
    WmStatus getInProgress();

    @Query("select ws from WmStatus ws where ws.id = 30")
    WmStatus getBacklog();

    @Query("select ws from WmStatus ws where ws.id = 110")
    WmStatus getActive();

    @Query("select ws from WmStatus ws where ws.id = 120")
    WmStatus getNotActive();

    @Query("select ws from WmStatus ws")
    List<WmStatus> findAllStatuses();
}
