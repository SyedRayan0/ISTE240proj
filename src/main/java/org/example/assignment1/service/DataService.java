package org.example.assignment1.service;

import org.example.assignment1.model.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class DataService {
    // Entity lists for Syed Rayan's contribution
    private final List<Event> eventList = new ArrayList<>();
    private final List<Users> userList = new ArrayList<>();

    // Entity lists for Ali Faisal's contribution
    private final List<Subscription> subscriptionList = new ArrayList<>();
    private final List<Administrator> adminList = new ArrayList<>();

    public DataService() {
        //  SEEDING INITIAL DATA RECORDS

        // Syed Rayan's Initial Data
        eventList.add(new Event("Hackathon", "Main Hall"));
        userList.add(new Users("Mostafa", "mostafa@example.com"));

        // Ali Faisal's Initial Data
        adminList.add(new Administrator()); //


        subscriptionList.add(new Subscription("SUB-101", "ali@rit.edu", "Hackathon"));
        subscriptionList.add(new Subscription("SUB-102", "student@rit.edu", "Tech Workshop"));
    }

    //  SYED RAYAN'S METHODS
    public List<Event> getAllEvents() { return eventList; }
    public void addEvent(Event event) { eventList.add(event); }

    public List<Users> getAllUsers() { return userList; }
    public void addUser(Users user) { userList.add(user); }

    //  ALI FAISAL'S METHODS

    public List<Subscription> getAllSubscriptions() {
        return subscriptionList;
    }


    public void addSubscription(Subscription subscription) {
        subscriptionList.add(subscription);
    }

    public List<Administrator> getAllAdministrators() {
        return adminList;
    }
}