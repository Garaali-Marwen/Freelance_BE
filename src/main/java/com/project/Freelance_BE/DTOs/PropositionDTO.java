package com.project.Freelance_BE.DTOs;

import com.project.Freelance_BE.Enum.PropositionState;

public record PropositionDTO(
        Long id,
        DeveloperDTO developer,
        PropositionState propositionState,
        ProjectDTO project
) {
}
