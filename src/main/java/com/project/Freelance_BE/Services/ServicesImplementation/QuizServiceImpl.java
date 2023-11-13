package com.project.Freelance_BE.Services.ServicesImplementation;

import com.project.Freelance_BE.DTOs.Mappers.QuizDTOMapper;
import com.project.Freelance_BE.DTOs.QuizDTO;
import com.project.Freelance_BE.Entities.Quiz;
import com.project.Freelance_BE.Repositories.QuizRepository;
import com.project.Freelance_BE.Services.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizServiceImpl  implements QuizService {

    private final QuizRepository quizRepository;
    private final QuizDTOMapper quizDTOMapper;
    @Override
    public QuizDTO addQuiz(Quiz quiz) {
        return  quizDTOMapper.apply(quizRepository.save(quiz));
    }

    @Override
    public QuizDTO getQuizById(Long quizId) {

        return quizDTOMapper.apply(quizRepository.findById(quizId).orElseThrow(() -> new NoSuchElementException(
                "Quiz not exist"
        )));
    }

    @Override
    public List<QuizDTO> getAllQuizzes() {
        List<Quiz> quizzes = quizRepository.findAll();
        return quizzes.stream()
                .map(quizDTOMapper::apply)
                .collect(Collectors.toList());
    }

    @Override
    public QuizDTO updateQuiz( Quiz quizDTO) {
        Quiz q =quizRepository.findById(quizDTO.getId()).orElseThrow(() -> new NoSuchElementException(
                "Quiz not exist"
        ));
        q.setQuizQuestions(quizDTO.getQuizQuestions());
        q.setBadges(quizDTO.getBadges());
        q.setQuizResults(quizDTO.getQuizResults());
        q.setTime(quizDTO.getTime());
        return  quizDTOMapper.apply(quizRepository.save(q));
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizRepository.deleteById(quizId);
    }
}