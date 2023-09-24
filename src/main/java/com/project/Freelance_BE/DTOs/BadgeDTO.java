package com.project.Freelance_BE.DTOs;

import com.project.Freelance_BE.Entities.File;

public record BadgeDTO(
        Long id,
        float minScore,
        File badgeIcon
) {
}
