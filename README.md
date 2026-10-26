# Employee Manager (Spring Boot + MySQL + Thymeleaf + Lombok)

A full-stack Spring Boot CRUD application developed for Labsheet 05.

## Features
- **Create**: Add employees with server-side validation (`@NotBlank`, `@Email`, `@Pattern`, `@Positive`).
- **Read**: List all registered employees with real-time employee count.
- **Update**: Edit existing employee details (department, salary, etc.).
- **Delete**: Remove employees with JavaScript confirmation prompt.
- **Search (Challenge)**: Search employees by name (`findByFullNameContainingIgnoreCase`).
- **Duplicate Prevention**: Rejects duplicate email registrations.
- **REST API**: Includes `/api/employees` endpoints for testing CRUD with Postman.
- **Database**: MySQL integration via Spring Data JPA / Hibernate with automatic table creation (`update`).

## Technologies Used
- **Java 17**
- **Spring Boot 4 / Spring Data JPA / Spring Web / Validation**
- **Thymeleaf & Bootstrap 5**
- **Lombok**
- **MySQL & phpMyAdmin**

## Getting Started

### 1. Database Setup
Ensure MySQL is running (via XAMPP or Docker on port 3306).
```sql
CREATE DATABASE IF NOT EXISTS employee_db;
```

If using Docker Compose:
```bash
docker compose up -d
```

### 2. Configuration
Copy `secrets.properties.example` to `secrets.properties` if you require custom database credentials:
```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

### 3. Run the Application
Run `EmployeeManagerApplication.java` from your IDE, or using Gradle:
```bash
./gradlew bootRun
```

### 4. Access the Web Application
Open your browser and navigate to:
```
http://localhost:8080
```
