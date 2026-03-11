package org.example.assignment1.model;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String title = "Default Event";
    private String description = "Event Description";
    private String date = "2026-02-20"; // simple string
    private String location = "Online";

    // 1. ADDED: Link to Subscription to satisfy Assignment 2 rules
    private List<Subscription> subscriptions = new ArrayList<>();


    public Event() {}


    public Event(String title, String location) {
        this.title = title;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    // 2. ADDED: Getters and setters for the new linked list
    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }
    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}