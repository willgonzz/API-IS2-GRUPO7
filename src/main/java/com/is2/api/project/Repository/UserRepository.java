package com.is2.api.project.Repository;

import java.util.Optional;

import com.is2.api.project.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findByUsername(String username);
}
