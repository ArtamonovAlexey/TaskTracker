package com.gmail.alexey375890.repository;

import com.gmail.alexey375890.model.WmUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WmUsersRepository extends JpaRepository<WmUsers, Long> {

    @Query("select wu from WmUsers wu where wu.id = :userId")
    WmUsers getById(Long userId);

    @Query("select wu from WmUsers wu where wu.username = :username")
    WmUsers getByUsername(String username);

    Optional<WmUsers> findByUsername(String username);
}
