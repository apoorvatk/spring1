package com.example.UniVerse.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.UniVerse.model.Student;


// JpaRepository<Student, Long> means this repository will manage Student entities with Long type ID
public interface StudentRepository extends JpaRepository<Student, Long> {
}