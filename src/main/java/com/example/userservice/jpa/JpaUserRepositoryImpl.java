package com.example.userservice.jpa;

import com.example.userservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaUserRepositoryImpl implements UserRepository {

    private final UserJpaRepository repository;

    @Override
    public UserEntity save(UserEntity userEntity) {
        return repository.save(userEntity);
    }
}
