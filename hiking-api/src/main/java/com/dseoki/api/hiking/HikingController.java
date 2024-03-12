package com.dseoki.api.hiking;

import com.dseoki.api.hiking.domain.HikingDto;
import com.dseoki.api.hiking.domain.HikingResponse;
import com.dseoki.util.CommonResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hiking")
public class HikingController {

    private final HikingService service;

    /**
     * @작성자: gawain
     * @작성일: 2024 03 06 오후 10:15
     */
    @GetMapping("")
    public ResponseEntity<List<HikingResponse>> searchHiking() {
        return new ResponseEntity<List<HikingResponse>>(service.searchHiking(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HikingResponse> getHiking(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<HikingResponse>(service.getHiking(id), HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity registHiking(@RequestBody HikingDto hikingDto) {
        service.insertHiking(hikingDto);
        return new ResponseEntity<>("hiking save", HttpStatus.OK);
    }
}
