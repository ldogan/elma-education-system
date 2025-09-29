package com.ldogan.elma.service;

import com.ldogan.elma.domain.Enrollment;
import com.ldogan.elma.domain.Student;
import com.ldogan.elma.exception.NotFoundException;
import com.ldogan.elma.repo.EnrollmentRepository;
import com.ldogan.elma.repo.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ReportService {
    private final StudentRepository studentRepo;
    private final EnrollmentRepository enrollmentRepo;

    public ReportService(StudentRepository studentRepo, EnrollmentRepository enrollmentRepo) {
        this.studentRepo = studentRepo;
        this.enrollmentRepo = enrollmentRepo;
    }

    public double gpa(Long studentId) {
        Student s = studentRepo.findById(studentId).orElseThrow(() -> new NotFoundException("Student not found: " + studentId));
        List<Enrollment> list = enrollmentRepo.findByStudent(s);
        if (list.isEmpty()) return 0.0;
        double sum = 0.0; int count = 0;
        for (Enrollment e : list) {
            if (e.getGrade() != null) { sum += e.getGrade(); count++; }
        }
        return count == 0 ? 0.0 : sum / count;
    }
}
