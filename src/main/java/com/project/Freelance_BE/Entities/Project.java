package com.project.Freelance_BE.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private File specifications;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Proposition> propositions = new ArrayList<>();
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();
    @ManyToOne
    private Developer developer;
    @OneToOne
    private Transaction transaction;
}
