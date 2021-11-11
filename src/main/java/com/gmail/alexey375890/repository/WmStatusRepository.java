package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WmStatusRepository extends JpaRepository<WmStatus, Long> {

    @Query("select ws from WmStatus ws where ws.id = :id")
    WmStatus getById(Long id);
}
