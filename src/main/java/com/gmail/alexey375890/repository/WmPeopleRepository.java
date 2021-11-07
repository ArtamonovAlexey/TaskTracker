package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmPeople;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WmPeopleRepository extends JpaRepository<WmPeople, Long> {
    Optional<WmPeople> findById(Long id);

    WmPeople getById(Long id);
}
