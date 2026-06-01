package com.example.university.controller;

import com.example.university.model.Student;
import com.example.university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() { return studentService.getAllStudents(); }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/course/{courseCode}")
    public ResponseEntity<?> getStudentsByCourse(@PathVariable String courseCode) {
        List<Student> students = studentService.getStudentsByCourseCode(courseCode);
        if (students.isEmpty()) {
            throw new com.example.university.exception.ResourceNotFoundException("No students found enrolled in course: " + courseCode);
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping("/year/{currentYear}")
    public ResponseEntity<?> getStudentsByYear(@PathVariable Integer currentYear) {
        List<Student> students = studentService.getStudentsByCurrentYear(currentYear);
        if (students.isEmpty()) {
            throw new com.example.university.exception.ResourceNotFoundException("No students found in year: " + currentYear);
        }
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) { return studentService.createStudent(student); }

    @PostMapping("/bulk")
    public List<Student> createStudentsBulk(@RequestBody List<Student> students) { return studentService.createStudentsBulk(students); }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return ResponseEntity.ok(studentService.updateStudent(id, studentDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Student with ID " + id + " has been successfully deleted.");
        return ResponseEntity.ok(response);
    }
}
