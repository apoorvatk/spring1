package com.example.UniVerse.controller;

import com.example.UniVerse.model.Student;
import com.example.UniVerse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000") // Adjust if needed
@RestController
@RequestMapping("/students") // Base URL for this controller
public class StudentController {
     
    @Autowired
    private StudentService studentService;

    // Create a new student
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // Read all students
    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Read a student by ID
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    // Update a student
    @PutMapping("/update/{id}")
public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
    return studentService.updateStudent(id, student);
}
 //Delete a student
@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
    boolean isDeleted = studentService.deleteStudent(id);
    
    if (isDeleted) {
        return ResponseEntity.ok(" Student with ID " + id + " deleted successfully.");
    } else {
        return ResponseEntity.status(404).body(" Student with ID " + id + " not found.");
    }
}
}
