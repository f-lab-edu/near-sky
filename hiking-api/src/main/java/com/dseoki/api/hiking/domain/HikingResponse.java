package com.dseoki.api.hiking.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HikingResponse {
    private Long id;

    /**
     * 산행지 명
     */
    private String title;

    /**
     * 산행 시작 시간
     */
    private String hikeStartDate;

    /**
     * 산행 종료 시간
     */
    private String hikeEndDate;

    /**
     * 산행 거리 (m)
     */
    private Integer distance;

    /**
     * 등산 예상 소요 시간 (분)
     */
    private Integer estimatedDuration;

    /**
     * 해발고도
     */
    private Integer elevation;

    /**
     * 산행 설명
     */
    private String description;

}
