package com.example.userservice.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
