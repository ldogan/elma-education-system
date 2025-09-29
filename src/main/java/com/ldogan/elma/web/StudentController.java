package com.ldogan.elma.web;

import com.ldogan.elma.domain.Enrollment;
import com.ldogan.elma.domain.Student;
import com.ldogan.elma.dto.EnrollRequest;
import com.ldogan.elma.dto.GradeRequest;
import com.ldogan.elma.dto.StudentDto;
import com.ldogan.elma.service.ReportService;
import com.ldogan.elma.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;
    private final ReportService reportService;

    public StudentController(StudentService studentService, ReportService reportService) {
        this.studentService = studentService;
        this.reportService = reportService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@Valid @RequestBody StudentDto dto) {
        return studentService.create(dto);
    }

    @GetMapping
    public List<Student> list() { return studentService.list(); }

    @GetMapping("/{id}")
    public Student get(@PathVariable Long id) { return studentService.get(id); }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @Valid @RequestBody StudentDto dto) {
        return studentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { studentService.delete(id); }

    @PostMapping("/enroll")
    public Enrollment enroll(@Valid @RequestBody EnrollRequest req) { return studentService.enroll(req); }

    @PostMapping("/grade")
    public Enrollment grade(@Valid @RequestBody GradeRequest req) { return studentService.grade(req); }

    @GetMapping("/{id}/gpa")
    public Map<String, Object> gpa(@PathVariable Long id) {
        double gpa = reportService.gpa(id);
        return Map.of("studentId", id, "gpa", gpa);
    }
}
