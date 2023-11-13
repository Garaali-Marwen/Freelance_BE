package com.project.Freelance_BE.Services;

import com.project.Freelance_BE.DTOs.QuizDTO;
import com.project.Freelance_BE.Entities.Quiz;

import java.util.List;

public interface QuizService {
    QuizDTO addQuiz (Quiz quiz);
    QuizDTO getQuizById(Long quizId);

    List<QuizDTO> getAllQuizzes();

    QuizDTO updateQuiz( Quiz quizDTO);

    void deleteQuiz(Long quizId);

}
