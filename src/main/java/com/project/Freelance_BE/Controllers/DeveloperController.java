package com.project.Freelance_BE.Controllers;

import com.project.Freelance_BE.DTOs.DeveloperDTO;
import com.project.Freelance_BE.Entities.Developer;
import com.project.Freelance_BE.Entities.File;
import com.project.Freelance_BE.Services.DeveloperService;
import com.project.Freelance_BE.Services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/developer")
@AllArgsConstructor
public class DeveloperController {
    private final DeveloperService developerService;
    private final FileService fileService;

    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public DeveloperDTO addDeveloper(@RequestPart("developer") Developer developer,
                                     @RequestPart("image") MultipartFile image) {
        try {
            File file = fileService.uploadFile(image);
            developer.setImage(file);
            return developerService.addDeveloper(developer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/all")
    public List<DeveloperDTO> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    @GetMapping("/{id}")
    public DeveloperDTO getDeveloperById(@PathVariable("id") Long id) {
        return developerService.getDeveloperById(id);
    }

    @PutMapping("/update")
    public DeveloperDTO updateDeveloper(@RequestBody DeveloperDTO developerDTO) {
        return developerService.updateDeveloper(developerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDeveloperById(@PathVariable("id") Long id) {
        developerService.deleteDeveloperById(id);
    }
}
