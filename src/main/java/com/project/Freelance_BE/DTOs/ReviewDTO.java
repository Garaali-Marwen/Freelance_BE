package com.project.Freelance_BE.DTOs;

public record ReviewDTO(
        Long id,
        ProjectDTO project,
        String comment,
        int rate
) {
}
