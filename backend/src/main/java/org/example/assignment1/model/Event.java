package org.example.assignment1.model;

// Author: Syed Rayan Hashmi (ID: 764000072)
// Entity: Event

import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title = "Default Event";

    @Column(length = 1000)
    private String description = "Event Description";

    private String date = "2026-02-20";

    private String location = "Online";

    public Event() {}

    public Event(String title, String location) {
        this.title = title;
        this.location = location;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public String toString() {
        return "Event{id=" + id + ", title='" + title + "', location='" + location + "'}";
    }
}
