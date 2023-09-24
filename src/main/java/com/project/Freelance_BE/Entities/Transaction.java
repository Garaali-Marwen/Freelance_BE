package com.project.Freelance_BE.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Project project;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Developer developer;
}
