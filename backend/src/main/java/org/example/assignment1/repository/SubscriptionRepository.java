package org.example.assignment1.repository;

// Author: Ali Faisal (ID: 415002117)
// Repository: SubscriptionRepository

import org.example.assignment1.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    // --- FIND methods ---

    // findById inherited from JpaRepository

    // findAll inherited from JpaRepository

    // findBySubscriberEmail - standard derived query
    List<Subscription> findBySubscriberEmail(String subscriberEmail);

    // findByEventTitle - custom JPQL query
    @Query("SELECT s FROM Subscription s WHERE LOWER(s.eventTitle) LIKE LOWER(CONCAT('%', :eventTitle, '%'))")
    List<Subscription> findByEventTitleContaining(@Param("eventTitle") String eventTitle);

    // findBySubscriptionId
    Optional<Subscription> findBySubscriptionId(String subscriptionId);

    // --- UPDATE method ---
    @Modifying
    @Transactional
    @Query("UPDATE Subscription s SET s.eventTitle = :eventTitle WHERE s.id = :id")
    int updateEventTitleById(@Param("id") Long id, @Param("eventTitle") String eventTitle);

    // --- DELETE method ---
    // deleteById inherited from JpaRepository
}
