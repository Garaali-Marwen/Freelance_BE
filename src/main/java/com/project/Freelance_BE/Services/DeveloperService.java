package com.project.Freelance_BE.Services;

import com.project.Freelance_BE.DTOs.DeveloperDTO;
import com.project.Freelance_BE.Entities.Developer;

import java.util.List;

public interface DeveloperService {
    DeveloperDTO addDeveloper(Developer developer);
    List<DeveloperDTO> getAllDevelopers();
    DeveloperDTO getDeveloperById(Long id);
    DeveloperDTO updateDeveloper(DeveloperDTO developerDTO);
    void deleteDeveloperById(Long id);
}
