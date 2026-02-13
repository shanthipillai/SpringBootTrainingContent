# Spring Boot Validation – Property Injection Assignment

## Question

### 1. Add Validation Dependency
Add the required validation dependency in your `pom.xml` file to enable Bean Validation support in a Spring Boot application.

---

### 2. Create `UserDetails` Class
Create a class named **`UserDetails`** and inject values from the `application.properties` file using **property injection**.

---

### 3. Apply Validations
The `UserDetails` class should contain the following fields with appropriate validation annotations:

- **name**
  - Must not be blank
  - Use `@NotBlank`

- **contact**
  - Should be a valid contact number
  - Use `@Pattern` **or** `@Max`

- **email**
  - Must be a valid email address
  - Use `@Email`

- **address**
  - Must not be null
  - Use `@NotNull`
  - Type: `Address`

---

### 4. Configuration
- Define all required properties in the `application.properties` file.
- Use `@ConfigurationProperties` and `@Validated` for property binding and validation.
- Ensure the application **fails at startup** if any validation constraint is violated.

---

### Notes
- Validation should be enabled using the appropriate Spring Boot starter.
- Configuration validation helps detect errors early during application startup.
