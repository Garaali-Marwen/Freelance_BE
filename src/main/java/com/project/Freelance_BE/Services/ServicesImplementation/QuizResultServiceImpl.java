package com.project.Freelance_BE.Services.ServicesImplementation;

import com.project.Freelance_BE.DTOs.Mappers.QuizResultDTOMapper;
import com.project.Freelance_BE.DTOs.QuizResultDTO;
import com.project.Freelance_BE.Entities.QuizResult;
import com.project.Freelance_BE.Repositories.QuizResultRepository;
import com.project.Freelance_BE.Services.QuizResultService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizResultServiceImpl implements QuizResultService {

    private final QuizResultRepository quizResultRepository;
    private final QuizResultDTOMapper quizResultDTOMapper;
    @Override
    public QuizResultDTO addQuizResult(QuizResult quizResult) {
        return  quizResultDTOMapper.apply(quizResultRepository.save(quizResult));
    }

    @Override
    public QuizResultDTO getQuizResultById(Long quizResultId) {
        return quizResultDTOMapper.apply(quizResultRepository.findById(quizResultId).orElseThrow(() -> new NoSuchElementException(
                "QuizResult not exist"
        )));
    }

    @Override
    public List<QuizResultDTO> getAllQuizzesResults() {
        List<QuizResult> quizzes = quizResultRepository.findAll();
        return quizzes.stream()
                .map(quizResultDTOMapper::apply)
                .collect(Collectors.toList());
    }

    @Override
    public QuizResultDTO updateQuizResult(QuizResult quizResultDTO) {
        QuizResult q =quizResultRepository.findById(quizResultDTO.getId()).orElseThrow(() -> new NoSuchElementException(
                "QuizResult not exist"
        ));
        q.setQuiz(quizResultDTO.getQuiz());
        q.setBadge(quizResultDTO.getBadge());
        q.setScore(quizResultDTO.getScore());
        return  quizResultDTOMapper.apply(quizResultRepository.save(q));
    }

    @Override
    public void deleteQuizResult(Long quizResultId) {
        quizResultRepository.deleteById(quizResultId);

    }
}

