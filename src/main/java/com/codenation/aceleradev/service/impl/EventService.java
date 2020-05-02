package com.codenation.aceleradev.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import com.codenation.aceleradev.entity.Event;
import com.codenation.aceleradev.entity.EventWithoutLog;
import com.codenation.aceleradev.repository.EventRepository;
import com.codenation.aceleradev.service.interfaces.EventServiceInterface;
import com.codenation.aceleradev.validator.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventService implements EventServiceInterface {

    @Autowired
    private EventRepository repository;

    public Event save(Event event) {
        event.setQuantity(event.getLogs().size());
        return repository.save(event);
    }

    @Override
    public Optional<Event> findById(Long eventId) {
        return repository.findById(eventId);
    }

    public Page<EventWithoutLog> findAll(Pageable pageable) {
        return repository.findAllEvents(pageable);
    }

    @Override
    public Page<EventWithoutLog> findByLevel(Level eventLevel, Pageable pageable) {
        return repository.findByLevel(eventLevel, pageable);
    }

    @Override
    public Page<EventWithoutLog> findByDescription(String eventDescription, Pageable pageable) {
        return repository.findByDescription(eventDescription, pageable);
    }

    @Override
    public Page<EventWithoutLog> findBySource(String eventSource, Pageable pageable) {
        return repository.findBySource(eventSource, pageable);
    }

    @Override
    public Page<EventWithoutLog> findByDate(LocalDate eventDate, Pageable pageable) {
        return repository.findByCreatedAtBetween(eventDate.atTime(LocalTime.MIN), eventDate.atTime(LocalTime.MAX),
                pageable);
    }

    @Override
    public Page<EventWithoutLog> findByQuantity(Integer eventQuantity, Pageable pageable) {
        return repository.findByQuantity(eventQuantity, pageable);
    }

}