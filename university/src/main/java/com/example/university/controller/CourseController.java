package com.example.university.controller;

import com.example.university.model.Course;
import com.example.university.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() { return courseService.getAllCourses(); }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) { return courseService.createCourse(course); }

    @PostMapping("/bulk")
    public List<Course> createCoursesBulk(@RequestBody List<Course> courses) { return courseService.createCoursesBulk(courses); }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return ResponseEntity.ok(courseService.updateCourse(id, courseDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Course with ID " + id + " has been successfully deleted.");
        return ResponseEntity.ok(response);
    }
}
