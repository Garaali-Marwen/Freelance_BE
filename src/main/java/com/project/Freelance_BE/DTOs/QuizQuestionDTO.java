package com.project.Freelance_BE.DTOs;

public record QuizQuestionDTO(
        Long id,
        String question,
        boolean questionType
) {
}
