package com.codenation.aceleradev.service.interfaces;

import java.time.LocalDate;
import java.util.Optional;

import com.codenation.aceleradev.entity.Event;
import com.codenation.aceleradev.entity.EventView;
import com.codenation.aceleradev.entity.Level;

public interface EventServiceInterface {

    Optional<Event> findById(Long eventId);

    Iterable<EventView> findByLevel(Level eventLevel, Integer pageNumber, Integer pageSize, String sortedFields);

    Iterable<EventView> findByDescription(String eventDescription, Integer pageNumber, Integer pageSize,
            String sortedFields);

    Iterable<EventView> findBySource(String eventSource, Integer pageNumber, Integer pageSize, String sortedFields);

    Iterable<EventView> findByDate(LocalDate eventDate, Integer pageNumber, Integer pageSize, String sortedFields);

    Iterable<EventView> findByQuantity(Long eventQuantity, Integer pageNumber, Integer pageSize, String sortedFields);

}