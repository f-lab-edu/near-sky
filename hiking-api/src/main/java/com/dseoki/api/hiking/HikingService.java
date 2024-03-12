package com.dseoki.api.hiking;

import com.dseoki.api.entity.Hiking;
import com.dseoki.api.hiking.domain.HikingDto;
import com.dseoki.api.hiking.domain.HikingResponse;
import com.dseoki.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: gawain
 * date: 2024-03-06
 * description:
 * ==============================
 * DATE     AUTHOR      NOTE
 * ------------------------------
 * 2024-03-06  gawain     최초생성
 */
@Service
@RequiredArgsConstructor
public class HikingService {

    private final HikingRepository repository;

    /**
     *
     * @작성자: gawain
     * @작성일: 2024 03 06 오후 10:10
     * @변경이력:
     * 이름    :   일자  :   근거자료    :   변경  :   내용
     * --------------------------------------------------------
     * gawain   : 2024 03 06 오후 10:10 :     : 신규개발 * @return
     */
    public List<HikingResponse> searchHiking() {
        List<HikingResponse> hikingList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        List<Hiking> entitys = repository.findAll();
        if (entitys != null && entitys.size() > 0) {
            hikingList = entitys.stream().map(e -> {
                return HikingResponse.builder()
                        .id(e.getId())
                        .title(e.getTitle())
                        .hikeStartDate(e.getHikeStartDate().format(formatter))
                        .hikeEndDate(e.getHikeEndDate().format(formatter))
                        .distance(e.getDistance())
                        .elevation(e.getElevation())
                        .estimatedDuration(e.getEstimatedDuration())
                        .description(e.getDescription())
                        .build();
            }).collect(Collectors.toList());
        }

        return hikingList;
    }

    public HikingResponse getHiking(Long id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        return repository.findById(id).map(e -> {
            return HikingResponse.builder()
                    .id(e.getId())
                    .title(e.getTitle())
                    .hikeStartDate(e.getHikeStartDate().format(formatter))
                    .hikeEndDate(e.getHikeEndDate().format(formatter))
                    .distance(e.getDistance())
                    .elevation(e.getElevation())
                    .estimatedDuration(e.getEstimatedDuration())
                    .description(e.getDescription())
                    .build();
        }).orElse(null);
    }

    public void insertHiking(HikingDto hikingDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        Hiking hiking = new Hiking();
        hiking.setTitle(hikingDto.getTitle());
        hiking.setHikeStartDate(LocalDateTime.parse(hikingDto.getHikeStartDate(), formatter));
        hiking.setHikeEndDate(LocalDateTime.parse(hikingDto.getHikeEndDate(), formatter));
        hiking.setDistance(hikingDto.getDistance());
        hiking.setElevation(hikingDto.getElevation());
        hiking.setEstimatedDuration(hikingDto.getEstimatedDuration());
        hiking.setDescription(hikingDto.getDescription());
        repository.save(hiking);
    }
}
