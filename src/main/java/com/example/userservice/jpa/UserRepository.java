package com.example.userservice.jpa;


import java.util.List;

public interface UserRepository {

    UserEntity save(UserEntity userEntity);
    UserEntity getUserById(String userId);
    List<UserEntity> findAllUser();
}
