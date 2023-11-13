package com.project.Freelance_BE.Services;

import com.project.Freelance_BE.DTOs.QuizQuestionDTO;
import com.project.Freelance_BE.DTOs.QuizResultDTO;
import com.project.Freelance_BE.Entities.Quiz;
import com.project.Freelance_BE.Entities.QuizQuestion;
import com.project.Freelance_BE.Entities.QuizResult;

import java.util.List;

public interface QuizResultService {
    QuizResultDTO addQuizResult (QuizResult quizResult);
    QuizResultDTO  getQuizResultById(Long quizResultId);

    List<QuizResultDTO> getAllQuizzesResults();

    QuizResultDTO  updateQuizResult( QuizResult quizResultDTO);

    void deleteQuizResult(Long quizResultId);
}
