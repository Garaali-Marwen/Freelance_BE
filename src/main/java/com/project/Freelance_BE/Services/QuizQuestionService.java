package com.project.Freelance_BE.Services;

import com.project.Freelance_BE.DTOs.QuizQuestionDTO;
import com.project.Freelance_BE.Entities.Quiz;
import com.project.Freelance_BE.Entities.QuizQuestion;

import java.util.List;

public interface QuizQuestionService {
    QuizQuestionDTO addQuizQuestion (QuizQuestion quizQuestion);
    QuizQuestionDTO getQuizQuestionById(Long quizQuestionId);

    List< QuizQuestionDTO> getAllQuizzesQuestions();

    QuizQuestionDTO updateQuizQuestion(  QuizQuestion quizQuestionDTO);

    void deleteQuizQuestion(Long quizQuestionId);
}
