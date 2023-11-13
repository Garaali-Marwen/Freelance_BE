package com.project.Freelance_BE.Controllers;


import com.project.Freelance_BE.DTOs.BadgeDTO;
import com.project.Freelance_BE.DTOs.QuizResultDTO;
import com.project.Freelance_BE.Entities.Badge;
import com.project.Freelance_BE.Entities.QuizResult;
import com.project.Freelance_BE.Services.BadgeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/badge")
@AllArgsConstructor
public class BadgeController {
    private final BadgeService badgeService;

    @PostMapping("/add")
    public BadgeDTO addBadge(@RequestBody Badge badge){
        return badgeService.addBadge(badge);
    }

    @GetMapping("/all")
    public List<BadgeDTO> getBadges() {
        return badgeService.getAllBadges();
    }

    @GetMapping("/{id}")
    public BadgeDTO getBadgeById(@PathVariable("id") Long id) {
        return badgeService.getBadgeById(id);

    }

    @PutMapping("/update")
    public BadgeDTO updateBadge(@RequestBody BadgeDTO badge) {
        return badgeService.updateBadge(badge);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBadgeById(@PathVariable("id") Long id) {
        badgeService.deleteBadge(id);
    }
}
