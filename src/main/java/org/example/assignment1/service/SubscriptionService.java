package org.example.assignment1.service;

// Author: Ali Faisal (ID: 415002117)
// Service: SubscriptionService

import org.example.assignment1.model.Subscription;
import org.example.assignment1.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Optional<Subscription> getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id);
    }

    public List<Subscription> searchByEventTitle(String eventTitle) {
        return subscriptionRepository.findByEventTitleContaining(eventTitle);
    }

    public List<Subscription> getSubscriptionsByEmail(String email) {
        return subscriptionRepository.findBySubscriberEmail(email);
    }

    @Transactional
    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Transactional
    public Subscription updateSubscription(Long id, Subscription updatedSub) {
        Optional<Subscription> existing = subscriptionRepository.findById(id);
        if (existing.isPresent()) {
            Subscription s = existing.get();
            s.setSubscriptionId(updatedSub.getSubscriptionId());
            s.setSubscriberEmail(updatedSub.getSubscriberEmail());
            s.setEventTitle(updatedSub.getEventTitle());
            return subscriptionRepository.save(s);
        }
        return null;
    }

    @Transactional
    public boolean deleteSubscription(Long id) {
        if (subscriptionRepository.existsById(id)) {
            subscriptionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
