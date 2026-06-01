package com.example.university.service;

import com.example.university.model.Course;
import com.example.university.repository.CourseRepository;
import com.example.university.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() { return courseRepository.findAll(); }
    public Course createCourse(Course course) { return courseRepository.save(course); }
    public List<Course> createCoursesBulk(List<Course> courses) { return courseRepository.saveAll(courses); }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course with ID " + id + " not found."));
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course course = getCourseById(id);
        course.setName(courseDetails.getName());
        course.setCode(courseDetails.getCode());
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }
}
