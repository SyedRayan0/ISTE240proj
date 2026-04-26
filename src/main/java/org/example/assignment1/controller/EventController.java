package org.example.assignment1.controller;

import org.example.assignment1.model.Event;
import org.example.assignment1.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EventController {

    private final DataService dataService;

    public EventController(DataService dataService) {
        this.dataService = dataService;
    }


    @GetMapping("/")
    public String home() {
        return "forward:/index.html";
    }


    @GetMapping("/events")
    public String viewEvents(Model model) {
        model.addAttribute("events", dataService.getAllEvents());
        return "events"; // returns events.mustache
    }


    @GetMapping("/events/add")
    public String showAddEventForm() {
        return "add-event"; // returns add-event.mustache
    }


    @PostMapping("/events/add")
    public String saveEvent(@ModelAttribute Event event) {
        dataService.addEvent(event);

        return "redirect:/add/success/Event";
    }


    @GetMapping("/add/success/{entityName}")
    public String showSuccess(@PathVariable String entityName, Model model) {

        model.addAttribute("entityName", entityName);
        return "success"; // returns success.mustache
    }
}