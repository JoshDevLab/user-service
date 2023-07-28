package com.example.userservice.jpa;

public interface CustomUserRepository {

    UserEntity customFindUserID(String userId);
}
