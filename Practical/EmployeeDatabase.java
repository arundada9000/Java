import java.sql.*;

public class EmployeeDatabase {
    public static void main(String[] args) {
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            String JDBC_URL = "jdbc:mysql://localhost:3306/practical";
            String USERNAME = "root";
            String PASSWORD = "";
            Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Create statement
            Statement stmt = conn.createStatement();

            // Create table
            String createTableSQL = "CREATE TABLE employee (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100)," +
                    "age INT," +
                    "position VARCHAR(100))";
            stmt.executeUpdate(createTableSQL);

            // Insert record
            String insertSQL = "INSERT INTO employee (name, age, position) VALUES ('Ankit Pangeni', 22, 'Manager')";
            stmt.executeUpdate(insertSQL);

            // Retrieve records
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") +
                        ", Position: " + rs.getString("position"));
            }

            // Close everything
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
