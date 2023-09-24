package com.project.Freelance_BE.DTOs;

public record TransactionDTO(
        Long id,
        ProjectDTO project,
        DeveloperDTO developer
) {
}
