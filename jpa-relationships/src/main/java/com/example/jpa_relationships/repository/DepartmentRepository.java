package com.example.jpa_relationships.repository;

import com.example.jpa_relationships.enums.DepartmentType;
import com.example.jpa_relationships.model.Department;
import com.example.jpa_relationships.enums.DepartmentType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;




    public Department save(Department department) {
        entityManager.persist(department);
        return department;
    }

    public void removeDepartment(Department department){
        entityManager.remove(department);
    }







    public Department getDepartmentById(Long deptId) {
        return entityManager.find(Department.class, deptId);
    }

//    public Optional<Department> findByName(DepartmentType name) {
//
//        try {
//            Department department = entityManager
//                    .createQuery(
//                            "SELECT d FROM Department d WHERE d.name = :name",
//                            Department.class
//                    )
//                    .setParameter("name", name)
//                    .getSingleResult();
//
//            return Optional.of(department);
//
//        } catch (NoResultException e) {
//            return Optional.empty();
//        }
//    }
}