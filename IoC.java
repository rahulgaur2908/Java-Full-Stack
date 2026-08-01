// 1. Dependency Interface
interface MessageService {
    void sendMessage(String message);
}

// 2. Concrete Implementation 1: Email
class EmailService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println(" [Email Sent]: " + message);
    }
}

// 3. Concrete Implementation 2: SMS
class SmsService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println(" [SMS Sent]: " + message);
    }
}

// 4. High-level Client Class relying on Dependency Injection
class NotificationController {
    private final MessageService messageService;

    // Dependency is INJECTED via Constructor (Inversion of Control)
    public NotificationController(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser(String text) {
        messageService.sendMessage(text);
    }
}

// 5. Execution Runner
public class IoC {
    public static void main(String[] args) {
        System.out.println("--- Day 33: Testing Dependency Injection ---");

        // Injecting Email Implementation
        MessageService emailService = new EmailService();
        NotificationController emailNotifier = new NotificationController(emailService);
        emailNotifier.notifyUser("Day 33 IoC & DI Concept Mastered!");

        // Swapping to SMS Implementation effortlessly without changing NotificationController code!
        MessageService smsService = new SmsService();
        NotificationController smsNotifier = new NotificationController(smsService);
        smsNotifier.notifyUser("Swapped service seamless via Constructor Injection!");
    }
}