package com.example.userservice.jpa;

import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepository extends CrudRepository<UserEntity, Long> {
}
