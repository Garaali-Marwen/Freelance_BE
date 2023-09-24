package com.project.Freelance_BE.DTOs;

import com.project.Freelance_BE.Entities.File;

public record ProjectDTO(
        Long id,
        File specifications,
        ClientDTO client
) {
}
