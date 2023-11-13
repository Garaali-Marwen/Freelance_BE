package com.project.Freelance_BE.Services.ServicesImplementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Freelance_BE.Configuration.JwtService;
import com.project.Freelance_BE.DTOs.AuthenticationRequest;
import com.project.Freelance_BE.DTOs.AuthenticationResponse;
import com.project.Freelance_BE.DTOs.Mappers.UserDTOMapper;
import com.project.Freelance_BE.DTOs.UserDTO;
import com.project.Freelance_BE.Entities.User;
import com.project.Freelance_BE.Repositories.UserRepository;
import com.project.Freelance_BE.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final UserDTOMapper userDTOMapper;

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword())
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(NoSuchElementException::new);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return userRepository.existsUserByEmail(email);
    }

    @Override
    public boolean existsUserByNewEmailExceptOldEmail(String newEmail, String oldEmail) {
        return userRepository.existsByEmailExceptEmail(newEmail, oldEmail);
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userDTOMapper.apply(userRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUserName(refreshToken);
        if (userEmail != null) {
            User user = this.userRepository.findByEmail(userEmail).orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }

    @Override
    public UserDTO updateUser(User user) {
        User userToUpdate = userRepository.findById(user.getId()).orElseThrow(NoSuchElementException::new);
        userToUpdate.setTel(user.getTel());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setImage(user.getImage());
        return userDTOMapper.apply(userRepository.save(userToUpdate));
    }

}
