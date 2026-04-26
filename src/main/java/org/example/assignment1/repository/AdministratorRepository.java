package org.example.assignment1.repository;

// Author: Ali Faisal (ID: 415002117)
// Repository: AdministratorRepository

import org.example.assignment1.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    // --- FIND methods ---

    // findById inherited from JpaRepository

    // findAll inherited from JpaRepository

    // findByDepartment - standard derived query
    List<Administrator> findByDepartment(String department);

    // findByAdminId - custom JPQL query
    @Query("SELECT a FROM Administrator a WHERE a.adminId = :adminId")
    Optional<Administrator> findByAdminId(@Param("adminId") String adminId);

    // findByAccessLevel
    List<Administrator> findByAccessLevel(String accessLevel);

    // --- UPDATE method ---
    @Modifying
    @Transactional
    @Query("UPDATE Administrator a SET a.department = :department WHERE a.id = :id")
    int updateDepartmentById(@Param("id") Long id, @Param("department") String department);

    // --- DELETE method ---
    // deleteById inherited from JpaRepository
}
