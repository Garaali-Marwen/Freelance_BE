package com.project.Freelance_BE.Services;

import com.project.Freelance_BE.DTOs.ProjectDTO;
import com.project.Freelance_BE.Entities.Project;

import java.util.List;

public interface ProjectService  {
    Project addProject(Project project);
    List<ProjectDTO> getAllProjects();
    ProjectDTO getProjectById(Long id);
    ProjectDTO updateProject(ProjectDTO projectDTO);
    void deleteProjectById(Long id);
}