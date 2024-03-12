package com.dseoki.api.hiking.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * fileName: HikingDto
 * author: gawain
 * date: 2024-03-12
 * description:
 * ==============================
 * DATE     AUTHOR      NOTE
 * ------------------------------
 * 2024-03-12  gawain     최초생성
 */
@Getter
@Setter
public class HikingDto {
    private String title;
    private String hikeStartDate;
    private String hikeEndDate;
    private Integer distance;
    private Integer estimatedDuration;
    private Integer elevation;
    private String description;
}
