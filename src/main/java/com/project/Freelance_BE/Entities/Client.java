package com.project.Freelance_BE.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Client extends User {
    @OneToMany(mappedBy = "client")
    private List<Project> projects = new ArrayList<>();
    @OneToMany(mappedBy = "client")
    private List<Review> reviews = new ArrayList<>();
    @OneToMany(mappedBy = "client")
    private List<Transaction> transactions = new ArrayList<>();
}
