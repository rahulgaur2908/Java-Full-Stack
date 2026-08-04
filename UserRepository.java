package com.rahul.fullstack.repository;

import com.rahul.fullstack.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // 1. Derived query method to find user by exact email
    Optional<UserEntity> findByEmail(String email);

    // 2. Derived query method to check if a username already exists
    boolean existsByUsername(String username);

    // 3. Derived query method for partial matching (SQL LIKE) ignoring case
    List<UserEntity> findByUsernameContainingIgnoreCase(String keyword);
}