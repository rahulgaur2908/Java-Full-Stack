// 1. Data Transfer Object (DTO) for incoming JSON payload
class UserDto {
    private String name;
    private String role;

    // Getters and Setters needed for Jackson JSON deserialization
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}

// 2. REST Controller managing HTTP Verbs & @RequestBody
@RestController
@RequestMapping("/api/v1/users")
public class UserPayloadController {

    // POST: Creating a new user using JSON payload
    @PostMapping
    public String createUser(@RequestBody UserDto user) {
        return String.format("✅ User Created: [Name: %s, Role: %s]", user.getName(), user.getRole());
    }

    // PUT: Updating an existing user
    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        return String.format("🔄 User ID %d Updated to: [Name: %s, Role: %s]", id, user.getName(), user.getRole());
    }

    // DELETE: Removing a user resource
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return "🗑️ User ID " + id + " deleted successfully.";
    }
}