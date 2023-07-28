package com.example.userservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long>, CustomUserRepository {
    UserEntity findByUserId(String userId);
}
