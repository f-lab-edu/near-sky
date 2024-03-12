package com.dseoki.api.hiking;

import com.dseoki.api.entity.Hiking;
import com.dseoki.api.hiking.domain.HikingDto;
import com.dseoki.api.hiking.domain.HikingResponse;
import com.dseoki.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

//        HikingResponse hikingResponse = HikingResponse.builder()
//                .title("월악산 악어봉 및 잔도길")
//                .hikeStartDate(DateUtils.getDateAsString(LocalDateTime.of(2024, 3, 9, 9, 30), "yyyy-MM-dd HH:mm"))
//                .hikeEndDate(DateUtils.getDateAsString(LocalDateTime.of(2024, 3, 9, 17, 30), "yyyy-MM-dd HH:mm"))
//                .distance(1000)
//                .elevation(448)
//                .estimatedDuration(60)
//                .description("아름다운 이 땅에 금수강산에 단군 할아버지가 터를 잘못 잡으시고... 동쪽에는 지진 서쪽에는 미세먼지 북쪽에는 시베리아 추위....")
//                .build();
//
//        hikingList.add(hikingResponse);
//        hikingList.add(hikingResponse);
//        hikingList.add(hikingResponse);
//        hikingList.add(hikingResponse);
//        hikingList.add(hikingResponse);
//        hikingList.add(hikingResponse);
//        hikingList.add(hikingResponse);
//        hikingList.add(hikingResponse);

        List<Hiking> entity = repository.findAll();
        if (entity != null && entity.size() > 0) {
            System.out.println("ssssssss");
        }
        System.out.println(entity);

        return hikingList;
    }

    public HikingResponse getHiking(Long id) {
        return HikingResponse.builder()
                .id(id)
                .title("월악산 악어봉 및 잔도길")
                .hikeStartDate(DateUtils.getDateAsString(LocalDateTime.of(2024, 3, 9, 9, 30), "yyyy-MM-dd HH:mm"))
                .hikeEndDate(DateUtils.getDateAsString(LocalDateTime.of(2024, 3, 9, 17, 30), "yyyy-MM-dd HH:mm"))
                .distance(1000)
                .elevation(448)
                .estimatedDuration(60)
                .description("아름다운 이 땅에 금수강산에 단군 할아버지가 터를 잘못 잡으시고... 동쪽에는 지진 서쪽에는 미세먼지 북쪽에는 시베리아 추위....")
                .build();
    }

    public void insertHiking(HikingDto hikingDto) {
        Hiking hiking = new Hiking();
        hiking.setTitle(hikingDto.getTitle());
        hiking.setHikeStartDate(LocalDateTime.parse(hikingDto.getHikeStartDate()));
        hiking.setHikeEndDate(LocalDateTime.parse(hikingDto.getHikeEndDate()));
        hiking.setDistance(hikingDto.getDistance());
        hiking.setElevation(hikingDto.getElevation());
        hiking.setEstimatedDuration(hikingDto.getEstimatedDuration());
        hiking.setDescription(hikingDto.getDescription());
        repository.save(hiking);
    }
}
