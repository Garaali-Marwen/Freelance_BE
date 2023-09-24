package com.project.Freelance_BE.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Quiz quiz;
    private float minScore;
    @OneToOne(cascade = CascadeType.ALL)
    private File badgeIcon;
}
