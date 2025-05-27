import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to database successfully!");

            try (Statement stmt = conn.createStatement()) {
                String createTableSQL = "CREATE TABLE IF NOT EXISTS users (" +
                        "id INT PRIMARY KEY AUTO_INCREMENT," +
                        "name VARCHAR(50) NOT NULL," +
                        "email VARCHAR(100) UNIQUE)";
                stmt.execute(createTableSQL);

                String insertSQL = "INSERT INTO users (name, email) VALUES " +
                        "('John Doe', 'john@example.com')," +
                        "('Jane Smith', 'jane@example.com')";
                stmt.executeUpdate(insertSQL);

                String selectSQL = "SELECT * FROM users";
                ResultSet rs = stmt.executeQuery(selectSQL);

                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") +
                            ", Name: " + rs.getString("name") +
                            ", Email: " + rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}