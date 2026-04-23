package org.example.assignment1;

// DataLoader: Seeds initial data into the iste240 database on startup
// Team: Syed Rayan Hashmi (ID: 764000072), Ali Faisal (ID: 415002117)

import org.example.assignment1.model.*;
import org.example.assignment1.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EventRepository eventRepository;
    private final UsersRepository usersRepository;
    private final AdministratorRepository adminRepository;
    private final SubscriptionRepository subscriptionRepository;

    public DataLoader(EventRepository eventRepository,
                      UsersRepository usersRepository,
                      AdministratorRepository adminRepository,
                      SubscriptionRepository subscriptionRepository) {
        this.eventRepository = eventRepository;
        this.usersRepository = usersRepository;
        this.adminRepository = adminRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public void run(String... args) {

        // Only seed if tables are empty
        if (eventRepository.count() == 0) {
            eventRepository.save(new Event("Hackathon 2026", "Main Hall"));
            eventRepository.save(new Event("Tech Workshop", "Lab A"));
            eventRepository.save(new Event("AI Conference", "Auditorium"));
        }

        if (usersRepository.count() == 0) {
            usersRepository.save(new Users("Mostafa Ahmed", "mostafa@example.com"));
            usersRepository.save(new Users("Sara Ali", "sara@example.com"));
            usersRepository.save(new Users("John Doe", "john@example.com"));
        }

        if (adminRepository.count() == 0) {
            adminRepository.save(new Administrator("ADM-001", "Full", "Operations"));
            adminRepository.save(new Administrator("ADM-002", "Read-Only", "Marketing"));
        }

        if (subscriptionRepository.count() == 0) {
            subscriptionRepository.save(new Subscription("SUB-101", "ali@rit.edu", "Hackathon 2026"));
            subscriptionRepository.save(new Subscription("SUB-102", "student@rit.edu", "Tech Workshop"));
            subscriptionRepository.save(new Subscription("SUB-103", "mostafa@example.com", "AI Conference"));
        }
    }
}
