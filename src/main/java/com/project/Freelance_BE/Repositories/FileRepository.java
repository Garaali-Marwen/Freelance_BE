package com.project.Freelance_BE.Repositories;

import com.project.Freelance_BE.Entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
