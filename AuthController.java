// 1. Validated Data Transfer Object (DTO)
class RegisterUserDto {

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email format")
    private String email;

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

// 2. REST Controller using @Valid & ResponseEntity
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody RegisterUserDto dto) {
        
        String responseMessage = String.format(
            "✅ User '%s' (%s) successfully registered!", 
            dto.getUsername(), 
            dto.getEmail()
        );

        // Returning explicit HTTP 201 Created status alongside response body
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMessage);
    }
}