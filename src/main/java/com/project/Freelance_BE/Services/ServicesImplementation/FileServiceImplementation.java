package com.project.Freelance_BE.Services.ServicesImplementation;

import com.project.Freelance_BE.Entities.File;
import com.project.Freelance_BE.Repositories.FileRepository;
import com.project.Freelance_BE.Services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
@AllArgsConstructor
public class FileServiceImplementation implements FileService {
    private final FileRepository fileRepository;

    @Override
    public File addFile(File file) {
        return fileRepository.save(file);
    }

    @Override
    public File uploadFile(MultipartFile multipartFile) throws IOException {
        if (!Objects.equals(multipartFile.getOriginalFilename(), "")) {
            File file = File
                    .builder()
                    .nom(multipartFile.getOriginalFilename())
                    .type(multipartFile.getContentType())
                    .imageBytes(multipartFile.getBytes())
                    .build();
            return addFile(file);
        }
        return null;
    }

    @Override
    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }
}
