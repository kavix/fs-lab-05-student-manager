# Employee Manager (Spring Boot + MySQL + Thymeleaf + Lombok)

A full-stack Spring Boot CRUD application developed for **Labsheet 05: Full-Stack Software Development (COSC 32133 / BECS 32263)**.

---

## Academic Information
- **Course**: COSC 32133 / BECS 32263 - Full-Stack Software Development
- **Institution**: Department of Statistics & Computer Science, University of Kelaniya
- **Lab Sheet**: Labsheet 05
- **Topic**: Spring Boot CRUD Application with MySQL, Lombok, Thymeleaf, and GitHub Workflow

---

## Features
- **Layered Architecture**: Entity, Repository, Service, Controller, and View.
- **Create**: Add employees with server-side validation (`@NotBlank`, `@Email`, `@Pattern`, `@Positive`).
- **Read**: List all registered employees with live employee count.
- **Update**: Edit existing employee details (department, salary, etc.) via dedicated form.
- **Delete**: Remove employees with JavaScript confirmation prompt.
- **Duplicate Email Prevention**: Prevents registering duplicate email addresses.
- **Search (Challenge Task 11)**: Search employees by name using `findByFullNameContainingIgnoreCase`.
- **REST API (Task 9)**: Fully featured endpoints at `/api/employees` for testing with Postman.
- **Secret Isolation (Task 10)**: Keeps database credentials out of Git history via `secrets.properties` and `.gitignore`.

---

## Technologies Used
- **Java 17**
- **Spring Boot 4 (Spring Data JPA, Spring Web MVC, Bean Validation)**
- **Thymeleaf & Bootstrap 5**
- **Project Lombok**
- **MySQL 8.0 & phpMyAdmin**
- **Apache Maven Wrapper (`mvnw`)**

---

## Getting Started

### 1. Database Setup
Start the containerized MySQL and phpMyAdmin services:
```bash
docker compose up -d
```
- **MySQL Database**: `localhost:3306` (Database: `employee_db`)
- **phpMyAdmin**: [http://localhost:8081](http://localhost:8081)
  - **Username**: `root`
  - **Password**: `rootpassword`

### 2. Configure Database Secrets (Optional)
If running outside the default Docker configuration, copy `secrets.properties.example` to `secrets.properties`:
```properties
spring.datasource.username=root
spring.datasource.password=rootpassword
```
*(This file is ignored by Git and will never enter the repository).*

### 3. Build & Run the Application
Run using the Maven Wrapper:
```bash
./mvnw clean spring-boot:run
```

### 4. Access the Web Application
Open your browser and navigate to:
```
http://localhost:8080
```

---

## REST API Endpoints (For Postman Testing)

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | `/api/employees` | List all employees (supports `?keyword=name`) |
| `GET` | `/api/employees/{id}` | Get employee by ID |
| `POST` | `/api/employees` | Create a new employee |
| `PUT` | `/api/employees/{id}` | Update existing employee |
| `DELETE` | `/api/employees/{id}` | Delete an employee |

### Sample JSON Payload (for POST / PUT):
```json
{
  "fullName": "Kasun Perera",
  "email": "kasun@example.com",
  "phone": "0771234567",
  "department": "Engineering",
  "salary": 85000.00
}
```
