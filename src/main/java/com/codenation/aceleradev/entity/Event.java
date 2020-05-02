package com.codenation.aceleradev.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.codenation.aceleradev.validator.Level;
import com.codenation.aceleradev.validator.NotLevel;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "Not found!")
    @Enumerated(EnumType.STRING)
    @NotLevel(anyOf = { Level.ERROR, Level.INFO, Level.WARNING })
    private Level level;

    @Column
    @NotEmpty(message = "Not found or is empty!")
    private String description;

    @Column
    @NotEmpty(message = "Not found or is empty!")
    private String source;

    @Column
    private Integer quantity;

    @Column
    @CreatedDate
    private LocalDateTime createdAt;

    @NotEmpty(message = "Not found or is empty!")
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonManagedReference
    private List<@Valid Log> logs;

}