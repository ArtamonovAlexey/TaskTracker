package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmProjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WmProjectsRepository extends JpaRepository<WmProjects, Long> {

    @Query("select wp from WmProjects wp where wp.id = :id")
    WmProjects getById(Long id);

    @Query("select wp from WmProjects wp")
    List<WmProjects> findAllProjects();

    @Query("select wp from WmProjects wp where wp.status.id = :statusId")
    List<WmProjects> findProjectsByStatusId(Long statusId);

}
