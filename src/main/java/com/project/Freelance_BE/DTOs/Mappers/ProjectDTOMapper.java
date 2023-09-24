package com.project.Freelance_BE.DTOs.Mappers;

import com.project.Freelance_BE.DTOs.ProjectDTO;
import com.project.Freelance_BE.Entities.Project;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@AllArgsConstructor
public class ProjectDTOMapper implements Function<Project, ProjectDTO> {
    private final ClientDTOMapper clientDTOMapper;
    @Override
    public ProjectDTO apply(Project project) {
        return new ProjectDTO(
                project.getId(),
                project.getSpecifications(),
                clientDTOMapper.apply(project.getClient())
        );
    }
}
