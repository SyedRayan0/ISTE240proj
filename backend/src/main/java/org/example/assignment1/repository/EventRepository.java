package org.example.assignment1.repository;

// Author: Syed Rayan Hashmi (ID: 764000072)
// Repository: EventRepository

import org.example.assignment1.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    // --- FIND methods ---

    // findById is inherited from JpaRepository

    // findAll is inherited from JpaRepository

    // findByLocation - standard derived query
    List<Event> findByLocation(String location);

    // findByTitle - custom JPQL query (satisfies "at least one must use JPQL")
    @Query("SELECT e FROM Event e WHERE LOWER(e.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Event> findByTitleContaining(@Param("title") String title);

    // findByDate
    List<Event> findByDate(String date);

    // --- UPDATE method ---
    @Modifying
    @Transactional
    @Query("UPDATE Event e SET e.location = :location WHERE e.id = :id")
    int updateLocationById(@Param("id") Long id, @Param("location") String location);

    // --- DELETE method ---
    // deleteById is inherited from JpaRepository
}
