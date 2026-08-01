// 1. Managed Spring Bean with Custom Scope and Lifecycle Callbacks
@Component
@Scope("prototype") // Creates a NEW instance every time context.getBean() is called
class DatabaseConnectorBean {

    public DatabaseConnectorBean() {
        System.out.println("1️ [Constructor] DatabaseConnectorBean instance created.");
    }

    @PostConstruct
    public void init() {
        System.out.println("2️ [@PostConstruct] Database connection initialized successfully.");
    }

    public void executeQuery() {
        System.out.println(" [Business Logic] Executing query on database connection...");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("3️ [@PreDestroy] Closing database connection and releasing resources...");
    }
}

// 2. Configuration Class enabling Component Scanning
@Configuration
@ComponentScan(basePackages = "com.rahul.fullstack")
class AppConfig {}

// 3. Application Execution
public class BeanLifecycle {
    public static void main(String[] args) {
        System.out.println("--- Day 35: Testing Spring Bean Scopes & Lifecycle ---");

        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext();

        System.out.println("\n--- Fetching Bean #1 ---");
        DatabaseConnectorBean bean1 = context.getBean(DatabaseConnectorBean.class);
        bean1.executeQuery();

        System.out.println("\n--- Fetching Bean #2 (Prototype Test) ---");
        DatabaseConnectorBean bean2 = context.getBean(DatabaseConnectorBean.class);

        System.out.println("\nAre bean1 and bean2 the same object reference? " + (bean1 == bean2));

        System.out.println("\n--- Closing Container ---");
        context.close(); // Triggers destruction lifecycle
    }
}