# Student REST API

## 📌 Objective
The objective of this project is to build a robust, scalable RESTful API using Spring Boot to manage university records, specifically tracking **Students** and their corresponding **Courses**. It implements clean separation of concerns using a Controller-Service-Repository architecture pattern, features an automated relational database mapping to MySQL, and includes robust global exception handlers to manage errors gracefully.

---

## 🛠️ Technologies Used
*   **Java 17 / 21** - Core application programming language.
*   **Spring Boot 3.x** - Framework for structuring the REST API.
*   **Spring Data JPA (Hibernate)** - Object-Relational Mapping (ORM) framework to interact with the database.
*   **MySQL Database** - Relational database engine for persistent storage.
*   **Jackson JSON** - Engine used for custom serialization and data output management.
*   **Maven** - Project build tool and dependency management configuration.

---

## ✨ Features Implemented
*   **Complete CRUD Operations**: Implements transactional `GET`, `POST`, `PUT`, and `DELETE` mapping mechanisms for both Students and Courses.
*   **Two Connected Models**: Clean relationship mapping tracking up to 11 basic student detail parameters tied to respective department profiles.
*   **Bulk Operations Capability**: Includes dedicated endpoints to batch-upload multiple records at once for seamless data testing.
*   **Optimized Performance Projections**: Leverages custom Spring Data Projection interfaces to selectively fetch student names on the course endpoint, drastically reducing memory usage.
*   **Dedicated Exception Handling Layer**: Utilizes a centralized `@ControllerAdvice` interceptor to capture malformed JSON layouts, query syntax anomalies, and missing record exceptions into clean, reliable JSON responses.
*   **Custom Property Formatting Rules**: Forces field-level output ordering strategies to match standard logical enterprise layouts.

---

## 🚀 Steps to Run the Application

### 1. Prerequisites
Ensure you have the following installed on your local computer system:
*   Java Development Kit (JDK 17 or higher)
*   MySQL Server
*   An IDE (IntelliJ IDEA, VS Code, or Eclipse)
*   An API testing client (Postman or Insomnia)

### 2. Database Configuration
1. Open your MySQL client shell or database administration GUI panel.
2. Run the following command to create the application schema workspace:
   ```sql
   CREATE DATABASE university_db;
   ```
3. Open your project source code file located at: `src/main/resources/application.properties`
4. Update the database credentials to match your local setup configuration parameters:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/university_db
   spring.datasource.username=YOUR_MYSQL_USERNAME
   spring.datasource.password=YOUR_MYSQL_PASSWORD
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

### 3. Build and Launch the Server
Navigate to the root folder location of the project using your operating system command terminal terminal window, then compile and run the engine using the internal Maven tool wrapped inside your workspace structure:

*   **For Windows systems:**
    ```bash
    mvnw.cmd spring-boot:run
    ```
*   **For Linux / macOS systems:**
    ```bash
    chmod +x mvnw
    ./mvnw spring-boot:run
    ```

The application environment engine will launch automatically on local device address port `http://localhost:8080`.

### 4. Basic API Interaction Endpoint Routes


| HTTP Verb | API Endpoints Routing Paths | Objective Functionality |
| :--- | :--- | :--- |
| **GET** | `/api/courses` | Fetch all branches in the system. |
| **POST** | `/api/courses/bulk` | Batch upload a collection of courses at once. |
| **GET** | `/api/students` | Retrieve the complete list of system students. |
| **GET** | `/api/students/course/{code}` | Get **only student names** belonging to a specific course code. |
| **GET** | `/api/students/year/{year}` | Retrieve students filtered by their academic standing year. |
| **POST** | `/api/students` | Register a single student tied to a course reference. |
| **PUT** | `/api/students/{id}` | Overwrite/Modify a student profile completely via their system ID. |
| **DELETE**| `/api/students/{id}` | Permanently drop a student record from the system database. |
