package com.rahul.fullstack.controller;

import com.rahul.fullstack.entity.UserEntity;
import com.rahul.fullstack.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserPaginationController {

    private final UserRepository userRepository;

    public UserPaginationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Endpoint: GET /api/v1/users?page=0&size=10&sortBy=username&direction=DESC
    @GetMapping
    public ResponseEntity<Page<UserEntity>> getUsersPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") String direction
    ) {
        Sort sort = direction.equalsIgnoreCase("DESC") 
                ? Sort.by(sortBy).descending() 
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<UserEntity> userPage = userRepository.findAll(pageable);

        return ResponseEntity.ok(userPage);
    }
}