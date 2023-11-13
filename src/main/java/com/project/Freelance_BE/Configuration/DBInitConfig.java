package com.project.Freelance_BE.Configuration;

import com.project.Freelance_BE.Entities.Admin;
import com.project.Freelance_BE.Enum.Role;
import com.project.Freelance_BE.Repositories.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DBInitConfig implements CommandLineRunner {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (adminRepository.count() == 0) {
            Admin admin = new Admin();
            admin.setRole(Role.ADMIN);
            admin.setEmail("admin@admin.com");
            admin.setPassword(passwordEncoder.encode("mmmmmmmm"));
            admin.setFirstName("Super");
            admin.setLastName("Admin");
            adminRepository.save(admin);
        }
    }
}
