package com.project.Freelance_BE.Services.ServicesImplementation;

import com.project.Freelance_BE.DTOs.BadgeDTO;
import com.project.Freelance_BE.DTOs.Mappers.BadgeDTOMapper;
import com.project.Freelance_BE.Entities.Badge;
import com.project.Freelance_BE.Repositories.BadgeRepository;
import com.project.Freelance_BE.Services.BadgeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BadgeServiceImplementation implements BadgeService {

    private  final BadgeRepository badgeRepository;
    private final BadgeDTOMapper badgeDTOMapper;


    @Override
    public BadgeDTO addBadge(Badge badge) {
        return  badgeDTOMapper.apply(badgeRepository.save(badge));
    }

    @Override
    public BadgeDTO getBadgeById(Long badgeId) {
        return badgeDTOMapper.apply(badgeRepository.findById(badgeId).orElseThrow(() -> new NoSuchElementException(
                "Badge not exist"
        )));
    }

    @Override
    public List<BadgeDTO> getAllBadges() {
        List< Badge > badges = badgeRepository.findAll();
        return badges.stream()
                .map(badgeDTOMapper::apply)
                .collect(Collectors.toList());
    }

    @Override
    public BadgeDTO updateBadge(BadgeDTO badgeDTO) {
        Badge b =badgeRepository.findById(badgeDTO.id()).orElseThrow(() -> new NoSuchElementException(
                "Badge not exist"
        ));
        b.setBadgeIcon(badgeDTO.badgeIcon());
        b.setMinScore(badgeDTO.minScore());
        return  badgeDTOMapper.apply(badgeRepository.save(b));
    }

    @Override
    public void deleteBadge(Long badgeId) {
        badgeRepository.deleteById(badgeId);
    }
}