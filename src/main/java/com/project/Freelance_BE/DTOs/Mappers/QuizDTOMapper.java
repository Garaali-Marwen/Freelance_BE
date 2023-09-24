package com.project.Freelance_BE.DTOs.Mappers;

import com.project.Freelance_BE.DTOs.QuizDTO;
import com.project.Freelance_BE.Entities.Quiz;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizDTOMapper implements Function<Quiz, QuizDTO> {
    private final BadgeDTOMapper badgeDTOMapper;
    private final QuizQuestionDTOMapper quizQuestionDTOMapper;

    @Override
    public QuizDTO apply(Quiz quiz) {
        return new QuizDTO(
                quiz.getId(),
                quiz.getBadges().stream().map(badgeDTOMapper).collect(Collectors.toList()),
                quiz.getQuizQuestions().stream().map(quizQuestionDTOMapper).collect(Collectors.toList()),
                quiz.getTime()
        );
    }
}
