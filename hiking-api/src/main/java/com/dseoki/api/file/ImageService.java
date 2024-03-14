package com.dseoki.api.file;

import com.dseoki.api.entity.Image;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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
                    // 이미지 valid
                    if (contentType.contains("image/jpeg")) {
                        originFileExtension = ".jpg";
                    } else if (contentType.contains("image/png")) {
                        originFileExtension = ".png";
                    } else if (contentType.contains("image/gif")) {
                        originFileExtension = ".gif";
                    } else {
                        break;
                    }
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

                file = new File(absolutePath + path + "/" + fileName);

                try {
                    // Files.copy()도 있었다... 대용량에 사용한다던데
                    multipartFile.transferTo(file);
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                    return "image upload fail...";
                }
            }
        }

        return "image upload complate!!";
    }

    public byte[] searchImage(Long targetId) throws IOException {
        Optional<Image> optionalImage = repository.findById(targetId);
        String directroy = null;
        if (optionalImage.isPresent()) {
            Image image = optionalImage.get();
            directroy = new File(image.getFilePath()).getAbsolutePath();
        }
        InputStream is = new FileInputStream(directroy);
        byte[] imageByteArray = is.readAllBytes();
        is.close();
        return imageByteArray;
    }
}
