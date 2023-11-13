package com.project.Freelance_BE.Services;

import com.project.Freelance_BE.DTOs.BadgeDTO;
import com.project.Freelance_BE.Entities.Badge;

import java.util.List;

public interface BadgeService {
    BadgeDTO addBadge (Badge badge);
    BadgeDTO getBadgeById(Long badgeId);

    List<BadgeDTO> getAllBadges();

    BadgeDTO updateBadge( BadgeDTO badgeDTO);

    void deleteBadge(Long badgeId);
}
