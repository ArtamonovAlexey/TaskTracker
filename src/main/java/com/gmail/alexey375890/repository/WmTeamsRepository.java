package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmTeams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WmTeamsRepository extends JpaRepository<WmTeams, Long> {

    @Query("select wt from WmTeams wt where wt.id = :id")
    WmTeams getById(Long id);
}
