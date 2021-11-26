package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmCompanies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WmCompaniesRepository extends JpaRepository<WmCompanies, Long> {

    @Query("select wc from WmCompanies wc where wc.id = :companyId")
    WmCompanies getById(Long companyId);

//    @Query("select wc from WmCompanies wc")
//    List<WmCompanies> findAllCompanies();
//
//    @Query("select wc from WmCompanies wc where wc.status = :statusId")
//    List<WmCompanies> findCompaniesByStatusId(Long statusId);

}
