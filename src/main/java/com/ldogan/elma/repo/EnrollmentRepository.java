package com.ldogan.elma.repo;

import com.ldogan.elma.domain.Enrollment;
import com.ldogan.elma.domain.Student;
import com.ldogan.elma.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudent(Student student);
    List<Enrollment> findByCourse(Course course);
    Optional<Enrollment> findByStudentAndCourse(Student student, Course course);
}
