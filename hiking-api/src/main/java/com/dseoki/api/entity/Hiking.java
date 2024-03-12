package com.dseoki.api.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * fileName: Hiking
 * author: gawain
 * date: 2024-03-12
 * description:
 * ==============================
 * DATE     AUTHOR      NOTE
 * ------------------------------
 * 2024-03-12  gawain     최초생성
 */
@Entity
@Setter
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
