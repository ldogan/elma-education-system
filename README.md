# ELMA – School Information System (Spring Boot)

**ELMA** is a minimal, production-style **School Information System** for managing Students, Teachers, Courses and Grades.

- **Stack:** Java 17 · Spring Boot 3 · Spring Data JPA · Validation · H2/MySQL
- **API Docs:** OpenAPI/Swagger at **/swagger-ui.html**
- **Run:** `mvn spring-boot:run` (H2 in-memory DB by default)

## Quick Start
```bash
mvn spring-boot:run
# H2 console: http://localhost:8080/h2-console
# JDBC URL: jdbc:h2:mem:elmadb
```

## Switch to MySQL
Edit `src/main/resources/application.properties` and uncomment the MySQL section.

## REST Endpoints (examples)
- `POST /api/students` → create student
- `GET /api/students` → list students
- `POST /api/students/enroll` → {studentId, courseId}
- `POST /api/students/grade` → {studentId, courseId, grade}
- `GET /api/students/{id}/gpa` → average grade (simple)

- `POST /api/teachers` / `GET /api/teachers`
- `POST /api/courses` / `GET /api/courses`

## Project Name
Requested name: **ELMA** (no organization name shown in code; generic, interview‑friendly English terms only).

## License
This project is released under the **MIT License** (see `LICENSE`).

---
Made with ❤️ using Spring Boot.
