package com.project.Freelance_BE.Services.ServicesImplementation;

import com.project.Freelance_BE.DTOs.Mappers.QuizQuestionDTOMapper;
import com.project.Freelance_BE.DTOs.QuizQuestionDTO;
import com.project.Freelance_BE.Entities.QuizQuestion;
import com.project.Freelance_BE.Repositories.QuizQuestionRepository;
import com.project.Freelance_BE.Services.QuizQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class QuizQuestionServiceImpl implements QuizQuestionService {
    private final QuizQuestionRepository quizQuestionRepository;
    private final QuizQuestionDTOMapper quizQuestionDTOMapper;
    @Override
    public QuizQuestionDTO addQuizQuestion(QuizQuestion quizQuestion) {
        return quizQuestionDTOMapper.apply(quizQuestionRepository.save(quizQuestion));
    }

    @Override
    public QuizQuestionDTO getQuizQuestionById(Long quizQuestionId) {
        return quizQuestionDTOMapper.apply(quizQuestionRepository.findById(quizQuestionId).orElseThrow(() -> new NoSuchElementException(
                "QuizQuestion not exist"
        )));
    }

    @Override
    public List<QuizQuestionDTO> getAllQuizzesQuestions() {
        List<QuizQuestion> quizzes = quizQuestionRepository.findAll();
        return quizzes.stream()
                .map(quizQuestionDTOMapper::apply)
                .collect(Collectors.toList());
    }

    @Override
    public QuizQuestionDTO updateQuizQuestion(QuizQuestion quizQuestionDTO) {
        QuizQuestion q =quizQuestionRepository.findById(quizQuestionDTO.getId()).orElseThrow(() -> new NoSuchElementException(
                "QuizQuestion not exist"
        ));
        q.setQuestion(quizQuestionDTO.getQuestion());
        q.setQuestionType(quizQuestionDTO.isQuestionType());
        return  quizQuestionDTOMapper.apply(quizQuestionRepository.save(q));
    }



    @Override
    public void deleteQuizQuestion(Long quizQuestionId) {
        quizQuestionRepository.deleteById(quizQuestionId);

    }
}
