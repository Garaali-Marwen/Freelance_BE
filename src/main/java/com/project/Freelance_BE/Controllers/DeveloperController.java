package com.project.Freelance_BE.Controllers;

import com.project.Freelance_BE.DTOs.DeveloperDTO;
import com.project.Freelance_BE.Entities.Developer;
import com.project.Freelance_BE.Services.DeveloperService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/developer")
@AllArgsConstructor
public class DeveloperController {
    private final DeveloperService developerService;
    @PostMapping("/add")
    public DeveloperDTO addDeveloper(@RequestBody Developer developer){
        return developerService.addDeveloper(developer);
    }
}
