package com.ldogan.elma.web;

import com.ldogan.elma.domain.Course;
import com.ldogan.elma.dto.CourseDto;
import com.ldogan.elma.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) { this.courseService = courseService; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@Valid @RequestBody CourseDto dto) { return courseService.create(dto); }

    @GetMapping
    public List<Course> list() { return courseService.list(); }

    @GetMapping("/{id}")
    public Course get(@PathVariable Long id) { return courseService.get(id); }

    @PutMapping("/{id}")
    public Course update(@PathVariable Long id, @Valid @RequestBody CourseDto dto) { return courseService.update(id, dto); }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { courseService.deleteById(id); }
}
