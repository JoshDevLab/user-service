package com.example.userservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryHad implements UserRepository {

    private final JpaRepository repository;
}
