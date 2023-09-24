package com.project.Freelance_BE.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;
    private boolean questionType;
    @ManyToOne
    private Quiz quiz;
}
