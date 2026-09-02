package com.rahul.fullstack.service;

import com.rahul.fullstack.entity.User;
import com.rahul.fullstack.repository.UserRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 1. READ: Cache result in Redis under key "users::<id>"
    @Cacheable(value = "users", key = "#id")
    public User getUserById(Long id) {
        // Simulates an expensive database query
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    // 2. UPDATE: Update DB and refresh the Redis cache entry
    @Transactional
    @CachePut(value = "users", key = "#user.id")
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // 3. DELETE: Remove record from DB and evict key from Redis
    @Transactional
    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}