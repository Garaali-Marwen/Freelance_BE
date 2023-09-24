package com.project.Freelance_BE.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Quiz quiz;
    @ManyToOne
    private Developer developer;
    private float score;
    @ManyToOne
    private Badge badge;
}
