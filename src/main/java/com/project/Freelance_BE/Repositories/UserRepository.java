package com.project.Freelance_BE.Repositories;

import com.project.Freelance_BE.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsUserByEmail(String email);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email AND u.email <> :exceptEmail")
    boolean existsByEmailExceptEmail(@Param("email") String email, @Param("exceptEmail") String exceptEmail);
}
