package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmCompanies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface WmCompaniesRepository extends JpaRepository<WmCompanies, Long> {
    Optional<WmCompanies> findById(Long id);

    WmCompanies getById(Long id);
}
