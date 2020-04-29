package com.codenation.aceleradev.controller;

import java.time.LocalDate;
import java.util.Optional;

import com.codenation.aceleradev.entity.Event;
import com.codenation.aceleradev.entity.EventView;
import com.codenation.aceleradev.entity.Level;
import com.codenation.aceleradev.service.impl.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/event")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping("/{eventId}")
    public Event findById(@PathVariable("eventId") Long eventId) {
        return service.findById(eventId).get();
    }

    @GetMapping
    public Iterable<EventView> findAll(@RequestParam(name = "level") Optional<Level> eventLevel,
            @RequestParam(name = "description") Optional<String> eventDescription,
            @RequestParam(name = "source") Optional<String> eventSource,
            @RequestParam(name = "date") @DateTimeFormat(pattern = "dd-MM-yyyy") Optional<LocalDate> eventDate,
            @RequestParam(name = "quantity") Optional<Long> eventQuantity,
            @RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortFields) {
        if (eventLevel.isPresent())
            return service.findByLevel(eventLevel.get(), pageNumber, pageSize, sortFields);
        if (eventDescription.isPresent())
            return service.findByDescription(eventDescription.get(), pageNumber, pageSize, sortFields);
        if (eventSource.isPresent())
            return service.findBySource(eventSource.get(), pageNumber, pageSize, sortFields);
        if (eventDate.isPresent())
            return service.findByDate(eventDate.get(), pageNumber, pageSize, sortFields);
        if (eventQuantity.isPresent())
            return service.findByQuantity(eventQuantity.get(), pageNumber, pageSize, sortFields);
        return null;
    }

    @PostMapping
    public Event save(@RequestBody Event event) {
        return service.save(event);
    }

}