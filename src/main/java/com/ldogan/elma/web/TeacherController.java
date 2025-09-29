package com.ldogan.elma.web;

import com.ldogan.elma.domain.Teacher;
import com.ldogan.elma.dto.TeacherDto;
import com.ldogan.elma.exception.NotFoundException;
import com.ldogan.elma.repo.TeacherRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    private final TeacherRepository teacherRepo;

    public TeacherController(TeacherRepository teacherRepo) { this.teacherRepo = teacherRepo; }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher create(@Valid @RequestBody TeacherDto dto) {
        Teacher t = new Teacher();
        t.setName(dto.name);
        t.setEmail(dto.email);
        return teacherRepo.save(t);
    }

    @GetMapping
    public List<Teacher> list() { return teacherRepo.findAll(); }

    @GetMapping("/{id}")
    public Teacher get(@PathVariable Long id) {
        return teacherRepo.findById(id).orElseThrow(() -> new NotFoundException("Teacher not found: " + id));
    }

    @PutMapping("/{id}")
    public Teacher update(@PathVariable Long id, @Valid @RequestBody TeacherDto dto) {
        Teacher t = get(id);
        t.setName(dto.name);
        t.setEmail(dto.email);
        return t;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { teacherRepo.deleteById(id); }
}
