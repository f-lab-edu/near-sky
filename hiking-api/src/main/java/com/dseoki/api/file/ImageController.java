package com.dseoki.api.file;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService service;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(Long targetId, @RequestParam("files") List<MultipartFile> multipartFiles) {
        String result = service.imageUpload(targetId, multipartFiles);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{targetId}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> searchImage(@PathVariable Long targetId) throws IOException {
        return new ResponseEntity<byte[]>(service.searchImage(targetId), HttpStatus.OK);
    }

}
