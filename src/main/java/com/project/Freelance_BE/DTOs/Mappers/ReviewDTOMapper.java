package com.project.Freelance_BE.DTOs.Mappers;

import com.project.Freelance_BE.DTOs.ReviewDTO;
import com.project.Freelance_BE.Entities.Review;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class ReviewDTOMapper implements Function<Review, ReviewDTO> {
    private final ProjectDTOMapper projectDTOMapper;

    @Override
    public ReviewDTO apply(Review review) {
        return new ReviewDTO(
                review.getId(),
                projectDTOMapper.apply(review.getProject()),
                review.getComment(),
                review.getRate()
        );
    }
}
