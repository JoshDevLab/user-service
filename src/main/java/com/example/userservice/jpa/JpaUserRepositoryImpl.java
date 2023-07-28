package com.example.userservice.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaUserRepositoryImpl implements UserRepository {

    private final UserJpaRepository repository;

    @Override
    public UserEntity save(UserEntity userEntity) {
        return repository.save(userEntity);
    }

    @Override
    public UserEntity getUserById(String userId) {
        return repository.customFindUserID(userId);
    }

    @Override
    public List<UserEntity> findAllUser() {
        return repository.findAll();
    }
}
