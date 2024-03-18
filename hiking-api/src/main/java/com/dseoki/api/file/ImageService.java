package com.dseoki.api.file;

import com.dseoki.api.entity.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository repository;

    public String imageUpload(Long targetId, List<MultipartFile> multipartFiles) {
        if (multipartFiles == null || multipartFiles.isEmpty()) {
            return "image upload empty";
        }

        final String absolutePath = new File("").getAbsolutePath() + "\\";
        final String current_date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        final String path = "images/" + current_date;

        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        for(MultipartFile multipartFile: multipartFiles) {
            if (!multipartFile.isEmpty()) {
                String contentType = multipartFile.getContentType();
                String originFileExtension;
                if (ObjectUtils.isEmpty(contentType)) {
                    break;
                } else {
                    String[] token = contentType.split("/");
                    if (!token[0].equals("image")) {
                        return "이미지 파일만 업로드 할 수 있습니다.";
                    }
                    originFileExtension = ".".concat(token[1]);
                }

                String fileName = Long.toString(System.nanoTime());
                Image image = Image.builder()
                        .targetId(targetId)
                        .originFileName(multipartFile.getOriginalFilename())
                        .filePath(path + "/" + fileName)
                        .fileSize(multipartFile.getSize())
                        .ext(originFileExtension)
                        .build();

                repository.save(image);

                file = new File(absolutePath + path + "/" + fileName + originFileExtension);

                try {
                    // Files.copy()도 있었다... 대용량에 사용한다던데
                    multipartFile.transferTo(file);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    return "image upload fail";
                }
            }
        }

        return "image upload complate!!";
    }

    public List<String> searchImage(Long targetId) {
        List<Image> imageList = repository.findByTargetId(targetId);

        return imageList.stream()
                .map(image -> "/" + image.getFilePath() + image.getExt())
                .collect(Collectors.toList());
    }
}
