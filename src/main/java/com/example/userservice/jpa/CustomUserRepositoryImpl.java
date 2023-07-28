package com.example.userservice.jpa;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserEntity customFindUserID(String userId) {
        return em.createQuery("select u from UserEntity u where u.userId = :userId", UserEntity.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }
}
