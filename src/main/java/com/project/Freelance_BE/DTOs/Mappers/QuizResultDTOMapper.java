package com.project.Freelance_BE.DTOs.Mappers;

import com.project.Freelance_BE.DTOs.QuizResultDTO;
import com.project.Freelance_BE.Entities.QuizResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class QuizResultDTOMapper implements Function<QuizResult, QuizResultDTO> {
    private final QuizDTOMapper quizDTOMapper;
    private final BadgeDTOMapper badgeDTOMapper;

    @Override
    public QuizResultDTO apply(QuizResult quizResult) {
        return new QuizResultDTO(
                quizResult.getId(),
                quizDTOMapper.apply(quizResult.getQuiz()),
                quizResult.getScore(),
                badgeDTOMapper.apply(quizResult.getBadge())
        );
    }
}
