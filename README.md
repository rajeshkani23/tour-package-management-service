# Tour Package Management Service

A Spring Boot microservice for managing tour packages. Features include creating, listing, fetching, and searching tours, with optional image upload and secured REST APIs. Built with Java 8+, Spring Boot, PostgreSQL, and Docker.

---

##  Tech Stack

- Java 8+ / Java 17─21  
- Spring Boot (Web, Data JPA)  
- PostgreSQL (or H2 for local testing)  
- Docker & Docker Compose  
- Testing: JUnit + Mockito  
- API Documentation: Swagger (Springdoc OpenAPI)  
- API Security: API Key header

---

##  Quick Start

### Local (via IDE or mvn)

1. Set up PostgreSQL and update DB settings in `application.properties`
2. Run app:
   ```bash
   mvn spring-boot:run
