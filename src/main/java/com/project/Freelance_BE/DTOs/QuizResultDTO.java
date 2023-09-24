package com.project.Freelance_BE.DTOs;

public record QuizResultDTO (
        Long id,
        QuizDTO quiz,
        float score,
        BadgeDTO badge
){
}
