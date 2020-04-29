package com.codenation.aceleradev.repository;

import java.time.LocalDateTime;

import com.codenation.aceleradev.entity.Event;
import com.codenation.aceleradev.entity.EventView;
import com.codenation.aceleradev.entity.Level;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    Page<EventView> findByLevel(Level eventLevel, Pageable pageable);

    Page<EventView> findByDescription(String eventDescription, Pageable pageable);

    Page<EventView> findBySource(String eventSource, Pageable pageable);

    Page<EventView> findByCreatedAtBetween(LocalDateTime eventDateStart, LocalDateTime eventDateEnd, Pageable pageable);

    Page<EventView> findByQuantity(Long eventQuantity, Pageable pageable);

}