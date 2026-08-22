package com.example.jpa_relationships.model;


import com.example.jpa_relationships.enums.DepartmentType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private DepartmentType name;

    @OneToMany(mappedBy = "department")
    @JsonManagedReference
    private List<Student> students = new ArrayList<>();
}
