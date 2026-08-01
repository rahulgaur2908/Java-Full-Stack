import java.util.List;

// 1. Model / Entity Class
class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}

// 2. DAO Interface (Defines the Data Access Contract)
interface UserDao {
    void save(User user);
    User findById(int id);
}

// 3. Concrete DAO Implementation (Handles JDBC Operations)
class UserDaoImpl implements UserDao {
    @Override
    public void save(User user) {
        // Simulating raw JDBC PreparedStatement logic
        System.out.println("[JDBC DAO] Executing INSERT INTO users VALUES (" + user.getId() + ", '" + user.getName() + "')");
    }

    @Override
    public User findById(int id) {
        // Simulating raw JDBC ResultSet mapping
        System.out.println("[JDBC DAO] Executing SELECT * FROM users WHERE id = " + id);
        return new User(id, "Rahul");
    }
}

// 4. Main Application (Clean & Decoupled Business Logic)
public class DAO {
    public static void main(String[] args) {
        System.out.println("--- Day 28: Testing the DAO Design Pattern ---");

        // Decoupled instantiation: Program to an interface, not an implementation!
        UserDao userDao = new UserDaoImpl();

        // High-level operations (No raw SQL mixed in main logic!)
        User newUser = new User(101, "Rahul");
        userDao.save(newUser);

        User fetchedUser = userDao.findById(101);
        System.out.println(" Retrieved User from DAO: " + fetchedUser.getName());
    }
}