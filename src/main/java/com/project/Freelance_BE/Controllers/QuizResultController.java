package com.project.Freelance_BE.Controllers;





import com.project.Freelance_BE.DTOs.QuizResultDTO;
import com.project.Freelance_BE.Entities.QuizResult;
import com.project.Freelance_BE.Services.QuizResultService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizResult")
@AllArgsConstructor
public class QuizResultController {
    private final QuizResultService quizResultService;

    @PostMapping("/add")
    public QuizResultDTO addQuizResult(@RequestBody QuizResult quizResult){
        return quizResultService.addQuizResult(quizResult);
    }

    @GetMapping("/all")
    public List<QuizResultDTO> getAllQuizResult() {
        return quizResultService.getAllQuizzesResults();
    }

    @GetMapping("/{id}")
    public QuizResultDTO getQuizResultById(@PathVariable("id") Long id) {
        return quizResultService.getQuizResultById(id);
    }

    @PutMapping("/update")
    public QuizResultDTO updateQuizResult(@RequestBody QuizResult quizResult) {
        return  quizResultService.updateQuizResult(quizResult);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuizResultById(@PathVariable("id") Long id) {
       quizResultService.deleteQuizResult(id);

    }
}
