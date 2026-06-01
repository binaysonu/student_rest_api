package com.example.university.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "students")
@JsonPropertyOrder({ 
    "id", 
    "firstName", 
    "lastName", 
    "email", 
    "phoneNumber", 
    "dateOfBirth", 
    "gender", 
    "enrollmentDate", 
    "major", 
    "currentYear", 
    "gpa", 
    "isActive", 
    "course" 
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String gender;
    private LocalDate enrollmentDate;
    private String major;
    private Integer currentYear; 
    private Double gpa;
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    // Keep all your existing Getters and Setters below exactly the same
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public Integer getCurrentYear() { return currentYear; }
    public void setCurrentYear(Integer currentYear) { this.currentYear = currentYear; }
    public Double getGpa() { return gpa; }
    public void setGpa(Double gpa) { this.gpa = gpa; }
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
