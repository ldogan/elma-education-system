package com.ldogan.elma.service;

import com.ldogan.elma.domain.Course;
import com.ldogan.elma.domain.Teacher;
import com.ldogan.elma.dto.CourseDto;
import com.ldogan.elma.exception.NotFoundException;
import com.ldogan.elma.repo.CourseRepository;
import com.ldogan.elma.repo.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseService {
    private final CourseRepository courseRepo;
    private final TeacherRepository teacherRepo;

    public CourseService(CourseRepository courseRepo, TeacherRepository teacherRepo) {
        this.courseRepo = courseRepo;
        this.teacherRepo = teacherRepo;
    }

    public Course create(CourseDto dto) {
        Course c = new Course();
        c.setName(dto.name);
        c.setCode(dto.code);
        if (dto.teacherId != null) {
            Teacher t = teacherRepo.findById(dto.teacherId).orElseThrow(() -> new NotFoundException("Teacher not found: " + dto.teacherId));
            c.setTeacher(t);
        }
        return courseRepo.save(c);
    }

    public List<Course> list() { return courseRepo.findAll(); }

    public Course get(Long id) {
        return courseRepo.findById(id).orElseThrow(() -> new NotFoundException("Course not found: " + id));
    }

    public Course update(Long id, CourseDto dto) {
        Course c = get(id);
        c.setName(dto.name);
        c.setCode(dto.code);
        if (dto.teacherId != null) {
            Teacher t = teacherRepo.findById(dto.teacherId).orElseThrow(() -> new NotFoundException("Teacher not found: " + dto.teacherId));
            c.setTeacher(t);
        } else {
            c.setTeacher(null);
        }
        return c;
    }

    public void deleteById(Long id) { courseRepo.deleteById(id); }
}
