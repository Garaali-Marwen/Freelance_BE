package com.project.Freelance_BE.Services.ServicesImplementation;

import com.project.Freelance_BE.DTOs.DeveloperDTO;
import com.project.Freelance_BE.DTOs.Mappers.DeveloperDTOMapper;
import com.project.Freelance_BE.Entities.Developer;
import com.project.Freelance_BE.Enum.Role;
import com.project.Freelance_BE.Repositories.DeveloperRepository;
import com.project.Freelance_BE.Services.DeveloperService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperRepository developerRepository;
    private final DeveloperDTOMapper developerDTOMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public DeveloperDTO addDeveloper(Developer developer) {
        developer.setRole(Role.DEVELOPER);
        developer.setPassword(passwordEncoder.encode(developer.getPassword()));
        return developerDTOMapper.apply(developerRepository.save(developer));
    }

    @Override
    public List<DeveloperDTO> getAllDevelopers() {
        return developerRepository.findAll().stream().map(developerDTOMapper).collect(Collectors.toList());
    }

    @Override
    public DeveloperDTO getDeveloperById(Long id) {
        return developerDTOMapper.apply(
                developerRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                        "Developer not found"
                ))
        );
    }

    @Override
    public DeveloperDTO updateDeveloper(DeveloperDTO developerDTO) {
        Developer developer = developerRepository.findById(
                developerDTO.id()).orElseThrow(() -> new NoSuchElementException(
                "Developer not found"
        ));
        developer.setTel(developerDTO.tel());
        developer.setFirstName(developerDTO.firstName());
        developer.setLastName(developerDTO.lastName());
        developer.setEmail(developerDTO.email());
        return developerDTOMapper.apply(developerRepository.save(developer));
    }

    @Override
    public void deleteDeveloperById(Long id) {
        developerRepository.deleteById(id);
    }
}
