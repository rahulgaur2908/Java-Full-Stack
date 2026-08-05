package com.rahul.fullstack.repository;

import com.rahul.fullstack.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // 1. Object-Oriented JPQL Query (Operates on UserEntity class, not database tables)
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email AND u.active = true")
    Optional<UserEntity> findActiveUserByEmail(@Param("email") String email);

    // 2. Native SQL Query (Operates directly on underlying MySQL/PostgreSQL table)
    @Query(value = "SELECT * FROM users u WHERE u.username LIKE CONCAT('%', :keyword, '%') AND u.created_at >= NOW() - INTERVAL 30 DAY", 
           nativeQuery = true)
    List<UserEntity> findRecentUsersByKeyword(@Param("keyword") String keyword);
}