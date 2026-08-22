package com.example.jpa_relationships.repository;

import com.example.jpa_relationships.model.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Profile profile){
        entityManager.persist(profile);
    }
}
