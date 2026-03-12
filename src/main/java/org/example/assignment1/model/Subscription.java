package org.example.assignment1.model;

public class Subscription {
    private String subscriptionId;
    private String subscriberEmail;
    private String eventTitle;


    private Administrator approvedBy;


    public Subscription() {}


    public Subscription(String subscriptionId, String subscriberEmail, String eventTitle) {
        this.subscriptionId = subscriptionId;
        this.subscriberEmail = subscriberEmail;
        this.eventTitle = eventTitle;
    }


    public String getSubscriptionId() { return subscriptionId; }
    public void setSubscriptionId(String subscriptionId) { this.subscriptionId = subscriptionId; }

    public String getSubscriberEmail() { return subscriberEmail; }
    public void setSubscriberEmail(String subscriberEmail) { this.subscriberEmail = subscriberEmail; }

    public String getEventTitle() { return eventTitle; }
    public void setEventTitle(String eventTitle) { this.eventTitle = eventTitle; }

    public Administrator getApprovedBy() { return approvedBy; }
    public void setApprovedBy(Administrator approvedBy) { this.approvedBy = approvedBy; }
}