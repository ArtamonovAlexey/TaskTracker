package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmTeams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WmTeamsRepository extends JpaRepository<WmTeams, Long> {

    @Query("select wt from WmTeams wt where wt.id = :id")
    WmTeams getById(Long id);

    @Query("select wt from WmTeams wt")
    List<WmTeams> findAllTeams();

    @Query("select wt from WmTeams wt where wt.status.id = :statusId")
    List<WmTeams> findTeamsByStatusId(Long statusId);

    @Query("select wt from WmTeams wt where wt.team.id = :developId")
    List<WmTeams> findTeamsByDevelopId(Long developId);

    @Query("select wt from WmTeams wt where wt.team.id = :developId and wt.status.id = :statusIdOfTeams")
    List<WmTeams> findTeamsByDevelopIdAndStatusId(Long developId, Long statusIdOfTeams);

}
