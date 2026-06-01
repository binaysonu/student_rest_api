package com.example.university.service;

import com.example.university.model.Student;
import com.example.university.repository.StudentRepository;
import com.example.university.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() { return studentRepository.findAll(); }
    public Student createStudent(Student student) { return studentRepository.save(student); }
    public List<Student> createStudentsBulk(List<Student> students) { return studentRepository.saveAll(students); }
    public List<Student> getStudentsByCurrentYear(Integer year) { return studentRepository.findByCurrentYear(year); }
    public List<Student> getStudentsByCourseCode(String code) { return studentRepository.findByCourseCode(code); }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with ID " + id + " does not exist in the database."));
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        student.setFirstName(studentDetails.getFirstName());
        student.setLastName(studentDetails.getLastName());
        student.setEmail(studentDetails.getEmail());
        student.setPhoneNumber(studentDetails.getPhoneNumber());
        student.setDateOfBirth(studentDetails.getDateOfBirth());
        student.setGender(studentDetails.getGender());
        student.setEnrollmentDate(studentDetails.getEnrollmentDate());
        student.setMajor(studentDetails.getMajor());
        student.setCurrentYear(studentDetails.getCurrentYear());
        student.setGpa(studentDetails.getGpa());
        student.setIsActive(studentDetails.getIsActive());
        
        if (studentDetails.getCourse() != null) {
            student.setCourse(studentDetails.getCourse());
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}
