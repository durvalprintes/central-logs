package com.codenation.aceleradev.controller;

import java.time.LocalDate;
import java.util.Optional;

import javax.validation.Valid;

import com.codenation.aceleradev.entity.Event;
import com.codenation.aceleradev.entity.EventWithoutLog;
import com.codenation.aceleradev.entity.Level;
import com.codenation.aceleradev.exception.ResourceNotFoundException;
import com.codenation.aceleradev.service.impl.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/event")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping("/{eventId}")
    @ResponseStatus(HttpStatus.OK)
    public Event findById(@PathVariable("eventId") Long eventId) {
        return service.findById(eventId).orElseThrow(() -> new ResourceNotFoundException("Evento"));
    }

    @GetMapping
    public Iterable<EventWithoutLog> findAll(@RequestParam(name = "level") Optional<Level> eventLevel,
            @RequestParam(name = "description") Optional<String> eventDescription,
            @RequestParam(name = "source") Optional<String> eventSource,
            @RequestParam(name = "date") @DateTimeFormat(pattern = "dd-MM-yyyy") Optional<LocalDate> eventDate,
            @RequestParam(name = "quantity") Optional<Integer> eventQuantity, Pageable pageable) {
        if (eventLevel.isPresent())
            return service.findByLevel(eventLevel.get(), pageable);
        if (eventDescription.isPresent())
            return service.findByDescription(eventDescription.get(), pageable);
        if (eventSource.isPresent())
            return service.findBySource(eventSource.get(), pageable);
        if (eventDate.isPresent())
            return service.findByDate(eventDate.get(), pageable);
        if (eventQuantity.isPresent())
            return service.findByQuantity(eventQuantity.get(), pageable);
        return service.findAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody Event event) {
        service.save(event);
    }

}