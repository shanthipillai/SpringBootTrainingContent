# Assignment 2 - Spring Boot Validation with Property Injection

## What this project shows
- Property binding using `@ConfigurationProperties`
- Startup validation using `@Validated`
- Bean Validation annotations like `@NotBlank`, `@Pattern`, `@Email`, and `@NotNull`

## Main class
- `src/main/java/com/training/assignment2/PropertyInjectionValidationApplication.java`

## Run the project
From `SpringBootTrainingContent` root:

```powershell
.\Code\SpringBootFirstApplication\mvnw.cmd -f "assignment 2/pom.xml" spring-boot:run
```

## Test validation failure
Run with an invalid email:

```powershell
java -jar "assignment 2/target/property-injection-validation-0.0.1-SNAPSHOT.jar" --assignment2.user.email=invalid-email
```

Spring Boot should fail at startup and show the validation message.
