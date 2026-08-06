package com.rahul.fullstack.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// 1. Parent Entity
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // One User can have Many Orders (Bidirectional, mapped by 'user' field in OrderEntity)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<OrderEntity> orders = new ArrayList<>();

    // Helper methods to maintain bidirectional sync safely
    public void addOrder(OrderEntity order) {
        orders.add(order);
        order.setUser(this);
    }

    // Getters and Setters omitted for brevity
}

// 2. Child Entity (Owning Side of Foreign Key)
@Entity
@Table(name = "orders")
class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    // Many Orders belong to One User (Foreign key 'user_id' stored in 'orders' table)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public void setUser(UserEntity user) { this.user = user; }
    // Getters and Setters omitted for brevity
}