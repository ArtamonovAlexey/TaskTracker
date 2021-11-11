package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmCompanies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WmCompaniesRepository extends JpaRepository<WmCompanies, Long> {

    @Query("select wc from WmCompanies wc where wc.id = :id")
    WmCompanies getById(Long id);
}
