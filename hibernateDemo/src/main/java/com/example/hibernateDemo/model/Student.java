package com.example.hibernateDemo.model;

import com.example.hibernateDemo.enums.StudentStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column( check = @CheckConstraint(
            name = "age_check",
            constraint = "age >= 18"
    ))
    private int age;
    private String city;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private StudentStatus status;
    @Convert(converter = BooleanToStringConverter.class)
    private Boolean isMonitor;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(
                    name = "houseNumber",
                    column = @Column(name = "student_house_number")
            ),
            @AttributeOverride(
                    name = "street",
                    column = @Column(name = "student_street")
            ),
            @AttributeOverride(
                    name = "city",
                    column = @Column(name = "student_city")
            ),
            @AttributeOverride(
                    name = "state",
                    column = @Column(name = "student_state")
            )
    })
    private Address address;

    @ElementCollection
    @CollectionTable(
            name = "student_skills",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private Set<String> skills;

    public Student() {}

    public Student(Long id, String name, int age, String city,
                   LocalDateTime createdAt, StudentStatus status,
                   Boolean isMonitor,
                   Address address, Set<String> skills) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.createdAt = createdAt;
        this.status = status;
        this.isMonitor = isMonitor;
        this.address = address;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public Boolean getMonitor() {
        return isMonitor;
    }

    public void setMonitor(Boolean monitor) {
        isMonitor = monitor;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
