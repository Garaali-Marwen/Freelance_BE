package com.project.Freelance_BE.Services;

import com.project.Freelance_BE.Entities.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    File addFile(File file);

    File uploadFile(MultipartFile multipartFile) throws IOException;

    void deleteFile(Long id);
}
