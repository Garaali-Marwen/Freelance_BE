package com.project.Freelance_BE.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Developer extends User{
    @OneToMany(mappedBy = "developer")
    private List<Project> projects = new ArrayList<>();
    @OneToMany(mappedBy = "developer")
    private List<Transaction> transactions = new ArrayList<>();
    @OneToMany(mappedBy = "developer")
    private List<QuizResult> quizResults = new ArrayList<>();
    @OneToMany(mappedBy = "developer")
    private List<Proposition> propositions = new ArrayList<>();
}
