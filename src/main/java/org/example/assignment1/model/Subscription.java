package org.example.assignment1.model;

import org.springframework.stereotype.Component;

@Component
public class Subscription {
    private String subscriptionId = "SUB-100";
    private String subscriberEmail = "attendee@example.com";
    private String eventTitle = "Initial Event";

    // Default Constructor [cite: 39]
    public Subscription() {}

    // Getters and Setters [cite: 39]
    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getSubscriberEmail() {
        return subscriberEmail;
    }

    public void setSubscriberEmail(String subscriberEmail) {
        this.subscriberEmail = subscriberEmail;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "subscriptionId='" + subscriptionId + '\'' +
                ", subscriberEmail='" + subscriberEmail + '\'' +
                ", eventTitle='" + eventTitle + '\'' +
                '}';
    }
}