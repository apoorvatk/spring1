package com.example.UniVerse.service;


import com.example.UniVerse.model.Student;
import com.example.UniVerse.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
}
// Read all students
public List<Student> getAllStudents() {
    return studentRepository.findAll();
}

// Read a student by ID
public Optional<Student> getStudentById(Long id) {
    return studentRepository.findById(id);
}
}
