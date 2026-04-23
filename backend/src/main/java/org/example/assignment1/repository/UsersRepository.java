package org.example.assignment1.repository;

// Author: Syed Rayan Hashmi (ID: 764000072)
// Repository: UsersRepository

import org.example.assignment1.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    // --- FIND methods ---

    // findById inherited from JpaRepository

    // findAll inherited from JpaRepository

    // findByEmail - standard derived query
    Optional<Users> findByEmail(String email);

    // findByName - custom JPQL query
    @Query("SELECT u FROM Users u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Users> findByNameContaining(@Param("name") String name);

    // findByRole
    List<Users> findByRole(String role);

    // --- UPDATE method ---
    @Modifying
    @Transactional
    @Query("UPDATE Users u SET u.role = :role WHERE u.id = :id")
    int updateRoleById(@Param("id") Long id, @Param("role") String role);

    // --- DELETE method ---
    // deleteById inherited from JpaRepository
}
