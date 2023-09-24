package com.project.Freelance_BE.DTOs.Mappers;

import com.project.Freelance_BE.DTOs.BadgeDTO;
import com.project.Freelance_BE.Entities.Badge;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BadgeDTOMapper implements Function<Badge, BadgeDTO> {
    @Override
    public BadgeDTO apply(Badge badge) {
        return new BadgeDTO(
                badge.getId(),
                badge.getMinScore(),
                badge.getBadgeIcon()
        );
    }
}
