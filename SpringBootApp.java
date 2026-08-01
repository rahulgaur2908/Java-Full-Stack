@SpringBootApplication
@RestController
public class SpringBootApp {

    public static void main(String[] args) {
        // Launches the embedded Tomcat server and initializes the Spring context
        SpringApplication.run(SpringBootApp.class, args);
        System.out.println("[Spring Boot Active] Server running on http://localhost:8080");
    }

    @GetMapping("/")
    public String welcome() {
        return " Spring Boot Application Initialized Successfully! Day 36/100 Milestone Reached.";
    }
}