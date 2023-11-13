package com.project.Freelance_BE.Controllers;



import com.project.Freelance_BE.DTOs.QuizQuestionDTO;
import com.project.Freelance_BE.Entities.QuizQuestion;
import com.project.Freelance_BE.Services.QuizQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizQuestion")
@AllArgsConstructor
public class QuizQuestionController {
    private final QuizQuestionService quizQuestionService;

    @PostMapping("/add")
    public QuizQuestionDTO addQuizQuestion(@RequestBody QuizQuestion quizQuestion){
        return quizQuestionService.addQuizQuestion(quizQuestion);
    }

    @GetMapping("/all")
    public List<QuizQuestionDTO> getAllQuizQuestion() {
        return quizQuestionService.getAllQuizzesQuestions();
    }



    @GetMapping("/{id}")
    public QuizQuestionDTO getQuizQuestionById(@PathVariable("id") Long id) {
        return quizQuestionService.getQuizQuestionById(id);

    }

    @PutMapping("/update")
    public QuizQuestionDTO updateQuizQuestion(@RequestBody QuizQuestion quizQuestion) {
        return quizQuestionService.updateQuizQuestion(quizQuestion);


    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuizQuestionById(@PathVariable("id") Long id) {
        quizQuestionService.deleteQuizQuestion(id);
    }

}
