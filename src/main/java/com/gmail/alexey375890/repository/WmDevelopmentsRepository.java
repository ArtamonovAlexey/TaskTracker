package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmDevelopments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WmDevelopmentsRepository extends JpaRepository<WmDevelopments, Long> {

    @Query("select wd from WmDevelopments wd where wd.id = :id")
    WmDevelopments getById(Long id);
}
