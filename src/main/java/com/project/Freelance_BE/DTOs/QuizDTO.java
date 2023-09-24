package com.project.Freelance_BE.DTOs;

import java.time.LocalTime;
import java.util.List;

public record QuizDTO(
        Long id,
        List<BadgeDTO> badges,
        List<QuizQuestionDTO> quizQuestions,
        LocalTime time
) {
}
