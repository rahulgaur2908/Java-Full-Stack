// 1. Domain Service Class
class MilestoneService {
    public void printMilestone() {
        System.out.println(" [Spring Bean Active] Day 34: Spring IoC Container successfully initialized!");
    }
}

// 2. Spring Configuration Class defining Managed Beans
@Configuration
class AppConfig {

    @Bean
    public MilestoneService milestoneService() {
        // Spring IoC Container manages this object instance
        return new MilestoneService();
    }
}

// 3. Application Execution Runner
public class SpringContainerDemo {
    public static void main(String[] args) {
        System.out.println("--- Day 34: Testing Spring IoC Container ---");

        // Initializing the Spring ApplicationContext using Java Configuration
        ApplicationContext context = new ApplicationContext();

        // Retrieving the managed Spring Bean from the Container
        MilestoneService milestone = context.getBean(MilestoneService.class);
        milestone.printMilestone();
    }
}