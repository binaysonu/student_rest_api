package com.example.university.repository;

import com.example.university.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    // Find students by the 'code' property inside the Course model
    List<Student> findByCourseCode(String courseCode);

    // Find students by their current year
    List<Student> findByCurrentYear(Integer currentYear);
}
