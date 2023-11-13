package com.project.Freelance_BE.DTOs;

import com.project.Freelance_BE.Entities.File;
import com.project.Freelance_BE.Enum.Role;

public record UserDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        String tel,
        Role role,
        File image
) {
}
