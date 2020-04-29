package com.codenation.aceleradev.service.interfaces;

import java.time.LocalDate;
import java.util.Optional;

import com.codenation.aceleradev.entity.Event;
import com.codenation.aceleradev.entity.EventWithoutLog;
import com.codenation.aceleradev.entity.Level;

public interface EventServiceInterface {

    Optional<Event> findById(Long eventId);

    Iterable<EventWithoutLog> findByLevel(Level eventLevel, Integer pageNumber, Integer pageSize, String sortedFields);

    Iterable<EventWithoutLog> findByDescription(String eventDescription, Integer pageNumber, Integer pageSize,
            String sortedFields);

    Iterable<EventWithoutLog> findBySource(String eventSource, Integer pageNumber, Integer pageSize,
            String sortedFields);

    Iterable<EventWithoutLog> findByDate(LocalDate eventDate, Integer pageNumber, Integer pageSize,
            String sortedFields);

    Iterable<EventWithoutLog> findByQuantity(Long eventQuantity, Integer pageNumber, Integer pageSize,
            String sortedFields);

}