package com.project.Freelance_BE.Services;

import com.project.Freelance_BE.DTOs.DeveloperDTO;
import com.project.Freelance_BE.Entities.Developer;

public interface DeveloperService {
    DeveloperDTO addDeveloper(Developer developer);
}
