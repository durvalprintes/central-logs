package com.codenation.aceleradev.service.interfaces;

import java.time.LocalDate;
import java.util.Optional;

import com.codenation.aceleradev.entity.Event;
import com.codenation.aceleradev.entity.EventWithoutLog;
import com.codenation.aceleradev.validator.Level;

import org.springframework.data.domain.Pageable;

public interface EventServiceInterface {

    Optional<Event> findById(Long eventId);

    Iterable<EventWithoutLog> findByLevel(Level eventLevel, Pageable pageable);

    Iterable<EventWithoutLog> findByDescription(String eventDescription, Pageable pageable);

    Iterable<EventWithoutLog> findBySource(String eventSource, Pageable pageable);

    Iterable<EventWithoutLog> findByDate(LocalDate eventDate, Pageable pageable);

    Iterable<EventWithoutLog> findByQuantity(Integer eventQuantity, Pageable pageable);

}