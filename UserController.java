@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    // 1. Using @PathVariable to retrieve a specific user by ID
    // Endpoint: GET http://localhost:8080/api/v1/users/101
    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long userId) {
        return " Fetched user profile for ID: " + userId;
    }

    // 2. Using @RequestParam to filter users via query parameters
    // Endpoint: GET http://localhost:8080/api/v1/users/search?role=developer&active=true
    @GetMapping("/search")
    public String searchUsers(
            @RequestParam(name = "role", defaultValue = "all") String role,
            @RequestParam(name = "active", defaultValue = "true") boolean active
    ) {
        return String.format("Searching users with Role: [%s] | Active Status: [%b]", role, active);
    }
}