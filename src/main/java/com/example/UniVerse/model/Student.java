package com.example.UniVerse.model;

import jakarta.persistence.*;

@Entity // Marks this class as a database table
@Table(name = "students") 
public class Student {
       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate ID
    private Long id;

    private String name;
    private String email;
    private int age;

    // Default constructor
    public Student() {}

    // Constructor with parameters
    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
