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
//Create a student
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
// Update a student 
public Student updateStudent(Long id, Student updatedStudent) {
    // Step 1: Find the existing student by ID
    Optional<Student> existingStudentOptional = studentRepository.findById(id);

    if (existingStudentOptional.isPresent()) {
        // Step 2: Get the existing student object
        Student existingStudent = existingStudentOptional.get();

        // Step 3: Update the student's details
        existingStudent.setName(updatedStudent.getName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setAge(updatedStudent.getAge());

        // Step 4: Save and return the updated student
        return studentRepository.save(existingStudent);
    } else {
        throw new RuntimeException("Student with ID " + id + " not found.");
    }
}

//  Delete a student by ID
public boolean deleteStudent(Long id) {
    Optional<Student> studentOptional = studentRepository.findById(id);
    
    if (studentOptional.isPresent()) {
        studentRepository.deleteById(id);
        return true;
    } else {
        return false; // Student not found
    }
}
}
