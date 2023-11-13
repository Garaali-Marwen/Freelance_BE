package com.project.Freelance_BE.DTOs.Mappers;

import com.project.Freelance_BE.DTOs.UserDTO;
import com.project.Freelance_BE.Entities.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getTel(),
                user.getRole(),
                user.getImage()
        );
    }
}