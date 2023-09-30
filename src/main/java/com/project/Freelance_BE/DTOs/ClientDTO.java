package com.project.Freelance_BE.DTOs;

import com.project.Freelance_BE.Entities.File;
import com.project.Freelance_BE.Enum.Role;

public record ClientDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        Role role,
        File image,
        String tel
) {
}
