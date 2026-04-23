package org.example.assignment1.service;

// Author: Syed Rayan Hashmi (ID: 764000072)
// Service: EventService

import org.example.assignment1.model.Event;
import org.example.assignment1.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public List<Event> searchByTitle(String title) {
        return eventRepository.findByTitleContaining(title);
    }

    public List<Event> getEventsByLocation(String location) {
        return eventRepository.findByLocation(location);
    }

    @Transactional
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Transactional
    public Event updateEvent(Long id, Event updatedEvent) {
        Optional<Event> existing = eventRepository.findById(id);
        if (existing.isPresent()) {
            Event e = existing.get();
            e.setTitle(updatedEvent.getTitle());
            e.setDescription(updatedEvent.getDescription());
            e.setDate(updatedEvent.getDate());
            e.setLocation(updatedEvent.getLocation());
            return eventRepository.save(e);
        }
        return null;
    }

    @Transactional
    public boolean deleteEvent(Long id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
