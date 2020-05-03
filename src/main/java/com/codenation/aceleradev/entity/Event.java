package com.codenation.aceleradev.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.codenation.aceleradev.validator.LevelEnum;
import com.codenation.aceleradev.validator.NotEnum;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "All details about the Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "The database generated Event ID")
    private Long id;

    @Column
    @NotNull(message = "Not found!")
    @NotEnum(enumClass = LevelEnum.class)
    @ApiModelProperty(notes = "The Event level", allowableValues = "ERROR, WARNING, INFO")
    private String level;

    @Column
    @NotEmpty(message = "Not found or is empty!")
    @ApiModelProperty(notes = "The Event description")
    private String description;

    @Column
    @NotEmpty(message = "Not found or is empty!")
    @ApiModelProperty(notes = "The Event source")
    private String source;

    @Column
    @ApiModelProperty(notes = "The quantity of logs which belongs to the Event")
    private Integer quantity;

    @Column
    @CreatedDate
    @ApiModelProperty(notes = "The Event created date in the database")
    @JsonProperty(required = false)
    private LocalDateTime createdAt;

    @NotEmpty(message = "Not found or is empty!")
    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonManagedReference
    private List<@Valid Log> logs;

}