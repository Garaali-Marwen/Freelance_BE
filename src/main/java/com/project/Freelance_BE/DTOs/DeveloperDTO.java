package com.project.Freelance_BE.DTOs;

import com.project.Freelance_BE.Entities.File;
import com.project.Freelance_BE.Enum.Role;

import java.util.List;

public record DeveloperDTO(
        Long id,
        String firstName,
        String lasName,
        String email,
        Role role,
        File image,
        List<QuizResultDTO> quizResults
) {
}
