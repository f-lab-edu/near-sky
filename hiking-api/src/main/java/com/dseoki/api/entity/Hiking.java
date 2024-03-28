package com.dseoki.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Hiking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    private String title;
    private LocalDateTime hikeStartDate;
    private LocalDateTime hikeEndDate;
    private Integer distance;
    private Integer estimatedDuration;
    private Integer elevation;
    @Lob
    private String description;
}
