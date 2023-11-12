package com.project.Freelance_BE.Controllers;


import com.project.Freelance_BE.DTOs.DeveloperDTO;
import com.project.Freelance_BE.DTOs.ProjectDTO;
import com.project.Freelance_BE.Entities.Project;
import com.project.Freelance_BE.Services.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;


    @PostMapping( "/add")
    public Project addProject(@RequestBody  Project project) {
        return projectService.addProject(project);

    }

    @GetMapping("/all")
    public List<ProjectDTO> getAllProjects() {
        return projectService.getAllProjects();
    }


    @GetMapping("/{id}")
    public ProjectDTO getProjectById(@PathVariable("id") Long id) {
        return projectService.getProjectById(id);
    }

    @PutMapping("/update")
    public ProjectDTO updateProject(@RequestBody ProjectDTO projectDTO) {
        return projectService.updateProject(projectDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProjectById(@PathVariable("id") Long id) {
        projectService.deleteProjectById(id);
    }
}
