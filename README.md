# Department API

A beginner Spring Boot REST API for managing departments.

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- ModelMapper
- Lombok
- Maven

## Features

- Create a department
- Get department by ID
- Get all departments
- Update a department
- Delete a department
- Request validation
- Duplicate department checking
- Global exception handling
- Standard API response format

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/department` | Get all departments |
| GET | `/department/{id}` | Get department by ID |
| POST | `/department` | Create department |
| PUT | `/department/{id}` | Update department |
| DELETE | `/department/{id}` | Delete department |


## Example Request

```json
{
  "title": "Computer Science",
  "isActive": true
}
```

## What I Learned

This project helped me practice:

- REST API development
- Spring Boot
- CRUD operations
- DTOs
- JPA/Hibernate
- ModelMapper
- Validation
- Exception handling
