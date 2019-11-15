package com.saint.anthony.ryanairspringweb.repository;

import com.saint.anthony.ryanairspringweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
