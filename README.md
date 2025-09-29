# elma-education-system
Lightweight School Information System (SIS) using Java, Spring Boot, and MySQL/H2.


#  ELMA – School Information System

ELMA is a **School Information System (SIS)** built with **Spring Boot**.  
It provides RESTful APIs for managing **students, teachers, courses, and grades**.  
The system is designed as a lightweight academic management solution for schools.

---

##  Features
- Student management (create, update, delete, list)  
- Teacher management and course assignments  
- Course management (CRUD, course codes, teacher binding)  
- Enrollment workflow (students ↔ courses)  
- Grade entry and simple GPA calculation  
- RESTful API with validation and exception handling  
- Runs with **H2 in-memory DB** by default, easily switchable to **MySQL**  

---

##  Tech Stack
- **Language:** Java 17  
- **Framework:** Spring Boot 3 (Web, Data JPA, Validation)  
- **Database:** H2 (default), MySQL (production-ready)  
- **Documentation:** OpenAPI/Swagger UI  
- **Build Tool:** Maven  

---

##  Getting Started
mvn spring-boot:run

### Clone the repository
```bash
git clone https://github.com/ldogan/elma-sis.git
cd elma-sis
