package com.codenation.aceleradev.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@EntityListeners(AuditingEntityListener.class)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "Level information not found!")
    private Level level;

    @Column
    @NotNull(message = "Description information not found!")
    private String description;

    @Column
    @NotNull(message = "Log information not found!")
    private String log;

    @Column
    @NotNull(message = "Source information not found!")
    private String source;

    @Column
    @NotNull(message = "Quantity information not found!")
    @Min(value = 1, message = "Minimum quantity is 1!")
    private Long quantity;

    @Column
    @CreatedDate
    private LocalDateTime createdAt;

}