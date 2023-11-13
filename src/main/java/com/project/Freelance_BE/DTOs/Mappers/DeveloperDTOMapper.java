package com.project.Freelance_BE.DTOs.Mappers;

import com.project.Freelance_BE.DTOs.DeveloperDTO;
import com.project.Freelance_BE.Entities.Developer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DeveloperDTOMapper implements Function<Developer, DeveloperDTO> {
    private final QuizResultDTOMapper quizResultDTOMapper;
    @Override
    public DeveloperDTO apply(Developer developer) {
        return new DeveloperDTO(
                developer.getId(),
                developer.getFirstName(),
                developer.getLastName(),
                developer.getEmail(),
                developer.getTel(),
                developer.getRole(),
                developer.getImage(),
                developer.getQuizResults().stream().map(quizResultDTOMapper).collect(Collectors.toList())
        );
    }
}
