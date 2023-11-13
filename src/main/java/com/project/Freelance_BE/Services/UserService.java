package com.project.Freelance_BE.Services;

import com.project.Freelance_BE.DTOs.AuthenticationRequest;
import com.project.Freelance_BE.DTOs.AuthenticationResponse;
import com.project.Freelance_BE.DTOs.UserDTO;
import com.project.Freelance_BE.Entities.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public interface UserService {

    AuthenticationResponse login(AuthenticationRequest request);
    boolean existsUserByEmail(String email);
    boolean existsUserByNewEmailExceptOldEmail(String newEmail, String oldEmail);
    UserDTO getUserById(Long id);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;

    UserDTO updateUser(User user);
}
