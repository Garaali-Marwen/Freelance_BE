package com.project.Freelance_BE.Repositories;

import com.project.Freelance_BE.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProjectRepository extends JpaRepository<Project, Long> {
}
