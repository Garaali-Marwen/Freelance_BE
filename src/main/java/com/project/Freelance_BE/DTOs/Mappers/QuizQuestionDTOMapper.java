package com.project.Freelance_BE.DTOs.Mappers;

import com.project.Freelance_BE.DTOs.QuizQuestionDTO;
import com.project.Freelance_BE.Entities.QuizQuestion;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class QuizQuestionDTOMapper implements Function<QuizQuestion, QuizQuestionDTO> {
    @Override
    public QuizQuestionDTO apply(QuizQuestion quizQuestion) {
        return new QuizQuestionDTO(
                quizQuestion.getId(),
                quizQuestion.getQuestion(),
                quizQuestion.isQuestionType()
        );
    }
}
