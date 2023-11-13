package com.project.Freelance_BE.Repositories;

import com.project.Freelance_BE.Entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
