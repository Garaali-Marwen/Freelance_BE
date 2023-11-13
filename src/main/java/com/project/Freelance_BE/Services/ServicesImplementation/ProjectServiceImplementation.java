package com.project.Freelance_BE.Services.ServicesImplementation;



import com.project.Freelance_BE.DTOs.Mappers.ProjectDTOMapper;
import com.project.Freelance_BE.DTOs.ProjectDTO;
import com.project.Freelance_BE.Entities.Project;
import com.project.Freelance_BE.Repositories.ProjectRepository;
import com.project.Freelance_BE.Services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service

public class ProjectServiceImplementation implements  ProjectService{
    private final ProjectRepository projectRepository;
    private final ProjectDTOMapper  projectDTOMapper;

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll().stream().map(projectDTOMapper).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        return projectDTOMapper.apply(
                projectRepository.findById(id).orElseThrow(() -> new NoSuchElementException(
                        "Project not found"
                ))
        );
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO) {
        Project project = projectRepository.findById(
                projectDTO.id()).orElseThrow(() -> new NoSuchElementException(
                "Project not found"
        ));

        return projectDTOMapper.apply(projectRepository.save(project));
    }

    @Override
    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);

    }
}
