package com.project.Freelance_BE.Controllers;

import com.project.Freelance_BE.DTOs.AuthenticationRequest;
import com.project.Freelance_BE.DTOs.AuthenticationResponse;
import com.project.Freelance_BE.DTOs.UserDTO;
import com.project.Freelance_BE.Entities.File;
import com.project.Freelance_BE.Entities.User;
import com.project.Freelance_BE.Services.FileService;
import com.project.Freelance_BE.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final FileService fileService;

    @PostMapping("/authenticate")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
        return userService.login(request);
    }

    @PostMapping("/refresh-token")
    public void refreshToken(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        userService.refreshToken(request, response);
    }

    @GetMapping("/email/{email}")
    public boolean existByEmail(@PathVariable("email") String email) {
        return userService.existsUserByEmail(email);
    }

    @GetMapping("/newEmail/{newEmail}/oldEmail/{oldEmail}")
    public boolean existsUserByNewEmailExceptOldEmail(@PathVariable("newEmail") String newEmail, @PathVariable("oldEmail") String oldEmail) {
        return userService.existsUserByNewEmailExceptOldEmail(newEmail, oldEmail);
    }

    @GetMapping("/id/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PutMapping(value = "/update", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public UserDTO updateDeveloper(@RequestPart("user") User user,
                                   @RequestPart("image") MultipartFile image) {
        try {
            String orgFileName = StringUtils.cleanPath(Objects.requireNonNull(image.getOriginalFilename()));
            if (!orgFileName.isEmpty()) {
                File file = fileService.uploadFile(image);
                user.setImage(file);
            }
            return userService.updateUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
