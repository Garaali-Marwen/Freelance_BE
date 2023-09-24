package com.project.Freelance_BE.Entities;

import com.project.Freelance_BE.Enum.PropositionState;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Proposition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Project project;
    @ManyToOne
    private Developer developer;
    @Enumerated(EnumType.STRING)
    private PropositionState propositionState;
}
