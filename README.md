# Tour Package Management Service

A Spring Boot microservice for managing tour packages. Features include creating, listing, fetching, and searching tours, with optional image upload and secured REST APIs. Built with Java 8+, Spring Boot, PostgreSQL, and Docker.

---

## Tech Stack

- Java 8+ / Java 17─21  
- Spring Boot (Web, Data JPA)  
- PostgreSQL (production)  
- Docker & Docker Compose  
- Testing: JUnit + Mockito  
- API Documentation: Swagger (Springdoc OpenAPI)  
- API Security: API Key header

---

## Quick Start (Local)

1. Configure DB in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tour_db
spring.datasource.username=postgres
spring.datasource.password=Rajesh@2303
server.port=8082
api.key=MY_SECRET_KEY_123
file.upload-dir=uploads/
