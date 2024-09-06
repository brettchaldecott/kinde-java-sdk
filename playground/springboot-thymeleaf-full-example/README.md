# Kinde Spring Thymeleaf Full Example

This project demonstrates the integration of OAuth2 login with Kinde using Spring Boot and Spring Security. The application provides a simple web interface with authentication and role-based authorization.

## Table of Contents

- [Requirements](#requirements)
- [Project Setup](#project-setup)
- [Configurations](#configurations)
- [Running the Application](#running-the-application)
- [Endpoints](#endpoints)
- [Security Configuration](#security-configuration)
- [Logout Handling](#logout-handling)

## Requirements

- Java 17 or later
- Maven 3.6+
- Spring Boot 3.3.3

## Project Setup

1. **Clone the repository:**

```bash
git clone https://github.com/kinde-oss/kinde-java-sdk.git
cd kinde-java-sdk
```

2. **Build the project:**

```bash
mvn clean install
```

3. **Run the application:**

```bash
cd playground/springboot-thymeleaf-full-example
mvn spring-boot:run
```

## Configurations

### Dependencies

The `pom.xml` includes the following essential dependencies:

- `spring-boot-starter-security`: Provides core Spring Security components.
- `spring-boot-starter-oauth2-client`: Enables OAuth2 client capabilities.
- `spring-boot-starter-oauth2-resource-server`: Supports resource server capabilities with JWT.
- `spring-boot-starter-thymeleaf`: Allows server-side rendering using Thymeleaf.
- `spring-webflux`: Required for the reactive WebClient used in OAuth2 requests.
- `kinde-core`: Kinde specific SDK for interacting with their API.

### Security Configuration

The security is configured in `SecurityConfig.java`. Key configurations include:

- **OAuth2 Login and Resource Server:** The application is set up as an OAuth2 client and resource server, using JWT for securing API endpoints.
- **Method-level Security:** Secures individual controller methods based on roles.
- **JWT Authority Extraction:** Extracts roles from the JWT `permissions` claim and maps them to Spring Security authorities.

## Running the Application

1. **Start the Application:**
   Run the application using the Maven command:

```bash
cd playground/springboot-thymeleaf-full-example
mvn spring-boot:run
```

2. **Access the Application:**
   Open your browser and navigate to `http://localhost:8080`.

## Endpoints

The application provides several endpoints:

- **`/home` or `/`** - Publicly accessible homepage.
- **`/admin`** - Accessible to users with the `admins` role.
- **`/read`** - Accessible to users with the `read` role.
- **`/dashboard`** - Displays the user's Kinde profile data.

## Security Configuration

- **Public Access:**
  The home page (`/home`) and static resources (`/css/**`) are accessible without authentication.

- **Authenticated Access:**
  Other routes require authentication, and access is controlled by roles. For example, `/admin` requires the `admins` role.

- **JWT Processing:**
  The JWT `permissions` claim is used to assign roles dynamically.

```java
private Collection<GrantedAuthority> extractAuthoritiesFromClaims(Jwt jwt) {
    var permissions = jwt.getClaimAsStringList("permissions");

    return permissions.stream()
            .map(permission -> new SimpleGrantedAuthority("ROLE_" + permission))
            .collect(Collectors.toList());
}
```

## Logout Handling

The application handles logout with the following settings:

- **Logout URL:** `/logout`
- **Logout Success URL:** `/home`
- **Session Management:** Invalidates the session and clears authentication.

```java
http
    .logout(logout -> logout
        .logoutUrl("/logout")
        .logoutSuccessUrl("/home")
        .addLogoutHandler(oidcLogoutHandler)
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        .clearAuthentication(true)
    );
```

## Conclusion

This project sets up a basic Spring Boot application with OAuth2 authentication and role-based authorization using Kinde. You can extend the functionality by customizing the roles, adding more endpoints, or integrating additional services as needed.