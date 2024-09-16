package com.hassan.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hassan.auth.model.entity.User;

@Repository
public interface AuthRepository extends JpaRepository<User, Long> {
    public User findByEmailAndPassword(String email, String password);
}
