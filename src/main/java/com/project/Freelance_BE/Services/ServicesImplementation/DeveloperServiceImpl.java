package com.project.Freelance_BE.Services.ServicesImplementation;

import com.project.Freelance_BE.DTOs.DeveloperDTO;
import com.project.Freelance_BE.DTOs.Mappers.DeveloperDTOMapper;
import com.project.Freelance_BE.Entities.Developer;
import com.project.Freelance_BE.Repositories.DeveloperRepository;
import com.project.Freelance_BE.Services.DeveloperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperRepository developerRepository;
    private final DeveloperDTOMapper developerDTOMapper;
    @Override
    public DeveloperDTO addDeveloper(Developer developer) {
        return developerDTOMapper.apply(developerRepository.save(developer));
    }
}
