package org.example.assignment1.controller;

import org.example.assignment1.model.Subscription;
import org.example.assignment1.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubscriptionController {
    private final DataService dataService;

    public SubscriptionController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/subscriptions")
    public String viewSubscriptions(Model model) {
        model.addAttribute("subscriptions", dataService.getAllSubscriptions());
        return "subscriptions";
    }

    @GetMapping("/subscriptions/add")
    public String showAddForm() {
        return "add-subscription";
    }

    @PostMapping("/subscriptions/add")
    public String saveSubscription(@ModelAttribute Subscription subscription) {
        dataService.addSubscription(subscription);

        return "redirect:/add/success/Subscription";
    }
}