package com.codenation.aceleradev.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import com.codenation.aceleradev.entity.Event;
import com.codenation.aceleradev.entity.EventWithoutLog;
import com.codenation.aceleradev.entity.Level;
import com.codenation.aceleradev.repository.EventRepository;
import com.codenation.aceleradev.service.interfaces.EventServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EventService implements EventServiceInterface {

    @Autowired
    private EventRepository repository;

    public Event save(Event event) {
        return repository.save(event);
    }

    @Override
    public Optional<Event> findById(Long eventId) {
        return repository.findById(eventId);
    }

    private Sort orderField(String field) {
        return field.contains("DESC") ? Sort.by(field.replace("DESC", "").replace("ASC", "")).descending()
                : Sort.by(field.replace("DESC", "").replace("ASC", "")).ascending();
    }

    private Pageable sortPage(Integer pageNumber, Integer pageSize, String sortFields) {
        String[] fields = sortFields.split(",");
        Sort sorted = orderField(fields[0]);
        for (int i = 1; i < fields.length; i++) {
            sorted = sorted.and(orderField(fields[i]));
        }
        return PageRequest.of(pageNumber, pageSize, sorted);
    }

    public Page<EventWithoutLog> findAll(Integer pageNumber, Integer pageSize, String sortFields) {
        return repository.findAllEvents(sortPage(pageNumber, pageSize, sortFields));
    }

    @Override
    public Page<EventWithoutLog> findByLevel(Level eventLevel, Integer pageNumber, Integer pageSize,
            String sortFields) {
        return repository.findByLevel(eventLevel, sortPage(pageNumber, pageSize, sortFields));
    }

    @Override
    public Page<EventWithoutLog> findByDescription(String eventDescription, Integer pageNumber, Integer pageSize,
            String sortFields) {
        return repository.findByDescription(eventDescription, sortPage(pageNumber, pageSize, sortFields));
    }

    @Override
    public Page<EventWithoutLog> findBySource(String eventSource, Integer pageNumber, Integer pageSize,
            String sortFields) {
        return repository.findBySource(eventSource, sortPage(pageNumber, pageSize, sortFields));
    }

    @Override
    public Page<EventWithoutLog> findByDate(LocalDate eventDate, Integer pageNumber, Integer pageSize,
            String sortFields) {
        return repository.findByCreatedAtBetween(eventDate.atTime(LocalTime.MIN), eventDate.atTime(LocalTime.MAX),
                sortPage(pageNumber, pageSize, sortFields));
    }

    @Override
    public Page<EventWithoutLog> findByQuantity(Long eventQuantity, Integer pageNumber, Integer pageSize,
            String sortFields) {
        return repository.findByQuantity(eventQuantity, sortPage(pageNumber, pageSize, sortFields));
    }

}