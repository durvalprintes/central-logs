package com.codenation.aceleradev.repository;

import java.time.LocalDateTime;

import com.codenation.aceleradev.entity.Event;
import com.codenation.aceleradev.entity.EventWithoutLog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    @Query("select e from Event e")
    Page<EventWithoutLog> findAllEvents(Pageable pageable);

    Page<EventWithoutLog> findByLevel(String eventLevel, Pageable pageable);

    Page<EventWithoutLog> findByDescription(String eventDescription, Pageable pageable);

    Page<EventWithoutLog> findBySource(String eventSource, Pageable pageable);

    Page<EventWithoutLog> findByCreatedAtBetween(LocalDateTime eventDateStart, LocalDateTime eventDateEnd,
            Pageable pageable);

    Page<EventWithoutLog> findByQuantity(Integer eventQuantity, Pageable pageable);

}