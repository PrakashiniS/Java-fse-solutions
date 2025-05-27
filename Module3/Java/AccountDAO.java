import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public void transferMoney(int fromAccount, int toAccount, double amount) throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);

            PreparedStatement withdrawStmt = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE account_id = ? AND balance >= ?");
            withdrawStmt.setDouble(1, amount);
            withdrawStmt.setInt(2, fromAccount);
            withdrawStmt.setDouble(3, amount);

            PreparedStatement depositStmt = conn.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE account_id = ?");
            depositStmt.setDouble(1, amount);
            depositStmt.setInt(2, toAccount);

            int withdrawResult = withdrawStmt.executeUpdate();
            if (withdrawResult == 0) {
                throw new SQLException("Insufficient funds or account not found");
            }

            int depositResult = depositStmt.executeUpdate();
            if (depositResult == 0) {
                throw new SQLException("Destination account not found");
            }

            conn.commit();
            System.out.println("Transfer completed successfully");

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            throw e;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public double getBalance(int accountId) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT balance FROM accounts WHERE account_id = ?")) {
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
            throw new SQLException("Account not found");
        }
    }
}