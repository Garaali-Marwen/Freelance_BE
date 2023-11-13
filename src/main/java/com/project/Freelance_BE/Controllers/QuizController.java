package com.project.Freelance_BE.Controllers;
import com.project.Freelance_BE.DTOs.QuizDTO;
import com.project.Freelance_BE.Entities.Quiz;
import com.project.Freelance_BE.Services.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@AllArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @PostMapping("/add")
    public QuizDTO addQuiz(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    @GetMapping("/all")
    public List<QuizDTO> getAllQuiz() {
        return quizService.getAllQuizzes();
    }


    @GetMapping("/{id}")
    public QuizDTO getQuizById(@PathVariable("id") Long id) {
        return quizService.getQuizById(id);

    }

    @PutMapping("/update")
    public QuizDTO updateQuiz(@RequestBody Quiz quiz) {
        return quizService.updateQuiz(quiz);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuizById(@PathVariable("id") Long id) {
        quizService.deleteQuiz(id);
    }

}
