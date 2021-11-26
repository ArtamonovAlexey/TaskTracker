package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmDevelopments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WmDevelopmentsRepository extends JpaRepository<WmDevelopments, Long> {

    @Query("select wd from WmDevelopments wd where wd.id = :developId")
    WmDevelopments getById(Long developId);



    @Query("select wd from WmDevelopments wd")
    List<WmDevelopments> findAllDevelopments();

    @Query("select wd from WmDevelopments wd where wd.status.id = :statusIdOfDevelopments")
    List<WmDevelopments> findDevelopmentsByStatusId(Long statusIdOfDevelopments);

    @Query("select wd from WmDevelopments wd where wd.project.id = :projectId")
    List<WmDevelopments> findDevelopmentsByProjectId(Long projectId);

    @Query("select wd from WmDevelopments wd " +
            "where wd.project.id = :projectId and wd.status.id = :statusIdOfDevelopments")
    List<WmDevelopments> findDevelopmentsByProjectIdAndStatusId(Long projectId, Long statusIdOfDevelopments);

}
