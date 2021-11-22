package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmPeople;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WmPeopleRepository extends JpaRepository<WmPeople, Long> {

    @Query("select wp from WmPeople wp where wp.id = :id")
    WmPeople getById(Long id);
}
