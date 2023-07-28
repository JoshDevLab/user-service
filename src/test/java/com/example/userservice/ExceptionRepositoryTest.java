package com.example.userservice;

import com.example.userservice.jpa.CustomUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;


@SpringBootTest
public class ExceptionRepositoryTest {

    @Autowired
    private CustomUserRepository customUserRepositoryImpl;

    @Test
    @DisplayName("예외 변환기 테스트")
    public void exceptionTest() {

        Assertions.assertThrows(EmptyResultDataAccessException.class,
                () -> customUserRepositoryImpl.customFindUserID("qweqwe"));
    }
}
