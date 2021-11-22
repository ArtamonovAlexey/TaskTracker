package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmCompanies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WmCompaniesRepository extends JpaRepository<WmCompanies, Long> {

    @Query("select wc from WmCompanies wc where wc.id = :id")
    WmCompanies getById(Long id);

    @Query("select wc from WmCompanies wc order by wc.name")
    List<WmCompanies> findWmCompaniesByName();

    @Query("select wc from WmCompanies wc order by wc.name desc")
    List<WmCompanies> findWmCompaniesByNameDesc();
}
