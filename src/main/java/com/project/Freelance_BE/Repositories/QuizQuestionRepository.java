package com.project.Freelance_BE.Repositories;

import com.project.Freelance_BE.Entities.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionRepository extends JpaRepository<QuizQuestion, Long> {
}
