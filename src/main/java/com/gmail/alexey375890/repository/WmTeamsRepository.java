package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmTeams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WmTeamsRepository extends JpaRepository<WmTeams, Long> {
    Optional<WmTeams> findById(Long id);

    WmTeams getById(Long id);
}
