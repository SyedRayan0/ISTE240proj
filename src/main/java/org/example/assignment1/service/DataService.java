package org.example.assignment1.service;

import org.example.assignment1.model.*;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    private List<Event> eventList = new ArrayList<>();
    private List<Users> userList = new ArrayList<>();

    public DataService() {
        // Seeding initial data records
        eventList.add(new Event("Hackathon", "Main Hall"));
        userList.add(new Users("Mostafa", "mostafa@example.com"));
    }

    public List<Event> getAllEvents() { return eventList; }
    public void addEvent(Event event) { eventList.add(event); }

    public List<Users> getAllUsers() { return userList; }
    public void addUser(Users user) { userList.add(user); }
}