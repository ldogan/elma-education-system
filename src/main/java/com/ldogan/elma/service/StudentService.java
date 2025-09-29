package com.ldogan.elma.service;

import com.ldogan.elma.domain.*;
import com.ldogan.elma.dto.*;
import com.ldogan.elma.exception.NotFoundException;
import com.ldogan.elma.repo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;
    private final EnrollmentRepository enrollmentRepo;

    public StudentService(StudentRepository studentRepo, CourseRepository courseRepo, EnrollmentRepository enrollmentRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.enrollmentRepo = enrollmentRepo;
    }

    public Student create(StudentDto dto) {
        Student s = new Student();
        s.setFirstName(dto.firstName);
        s.setLastName(dto.lastName);
        s.setEmail(dto.email);
        return studentRepo.save(s);
    }

    public List<Student> list() { return studentRepo.findAll(); }

    public Student get(Long id) {
        return studentRepo.findById(id).orElseThrow(() -> new NotFoundException("Student not found: " + id));
    }

    public Student update(Long id, StudentDto dto) {
        Student s = get(id);
        s.setFirstName(dto.firstName);
        s.setLastName(dto.lastName);
        s.setEmail(dto.email);
        return s;
    }

    public void delete(Long id) { studentRepo.deleteById(id); }

    public Enrollment enroll(EnrollRequest req) {
        Student s = get(req.studentId);
        Course c = courseRepo.findById(req.courseId).orElseThrow(() -> new NotFoundException("Course not found: " + req.courseId));
        return enrollmentRepo.findByStudentAndCourse(s, c).orElseGet(() -> {
            Enrollment e = new Enrollment();
            e.setStudent(s);
            e.setCourse(c);
            return enrollmentRepo.save(e);
        });
    }

    public Enrollment grade(GradeRequest req) {
        Student s = get(req.studentId);
        Course c = courseRepo.findById(req.courseId).orElseThrow(() -> new NotFoundException("Course not found: " + req.courseId));
        Enrollment e = enrollmentRepo.findByStudentAndCourse(s, c)
                .orElseThrow(() -> new NotFoundException("Enrollment not found for student " + s.getId() + " in course " + c.getId()));
        e.setGrade(req.grade);
        return e;
    }
}
