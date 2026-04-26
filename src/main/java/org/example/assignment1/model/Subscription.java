package org.example.assignment1.model;

// Author: Ali Faisal (ID: 415002117)
// Entity: Subscription

import jakarta.persistence.*;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String subscriptionId;

    @Column(nullable = false)
    private String subscriberEmail;

    @Column(nullable = false)
    private String eventTitle;

    public Subscription() {}

    public Subscription(String subscriptionId, String subscriberEmail, String eventTitle) {
        this.subscriptionId = subscriptionId;
        this.subscriberEmail = subscriberEmail;
        this.eventTitle = eventTitle;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSubscriptionId() { return subscriptionId; }
    public void setSubscriptionId(String subscriptionId) { this.subscriptionId = subscriptionId; }

    public String getSubscriberEmail() { return subscriberEmail; }
    public void setSubscriberEmail(String subscriberEmail) { this.subscriberEmail = subscriberEmail; }

    public String getEventTitle() { return eventTitle; }
    public void setEventTitle(String eventTitle) { this.eventTitle = eventTitle; }

    @Override
    public String toString() {
        return "Subscription{id=" + id + ", subscriptionId='" + subscriptionId + "', email='" + subscriberEmail + "'}";
    }
}
