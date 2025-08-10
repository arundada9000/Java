// javac -cp ".;C:\Program Files\Java\mysql-connector-j-9.4.0\mysql-connector-j-9.4.0.jar" JDBCFullExample.java
// java -cp ".;C:\Program Files\Java\mysql-connector-j-9.4.0\mysql-connector-j-9.4.0.jar" JDBCFullExample

import java.sql.*;

public class JDBCFullExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // DB URL
        String user = "root"; // MySQL username
        String password = "root"; // MySQL password

        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Load JDBC Driver (optional in newer Java, but good for exams)
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");

            // 2. Connect to MySQL
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database.");

            // 3. Create table if not exists
            stmt = conn.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50), " +
                    "age INT)";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'students' created or already exists.");

            // 4. Insert data using PreparedStatement
            String insertSQL = "INSERT INTO students (name, age) VALUES (?, ?)";
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, "Alice");
            pstmt.setInt(2, 22);
            pstmt.executeUpdate();

            pstmt.setString(1, "Bob");
            pstmt.setInt(2, 24);
            pstmt.executeUpdate();

            pstmt.setString(1, "Charlie");
            pstmt.setInt(2, 21);
            pstmt.executeUpdate();

            System.out.println("Data inserted successfully.");

            // 5. Update a record
            String updateSQL = "UPDATE students SET age = ? WHERE name = ?";
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setInt(1, 25);
            pstmt.setString(2, "Bob");
            pstmt.executeUpdate();
            System.out.println("Record updated successfully.");

            // 6. Delete a record
            String deleteSQL = "DELETE FROM students WHERE name = ?";
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setString(1, "Charlie");
            pstmt.executeUpdate();
            System.out.println("Record deleted successfully.");

            // 7. Select all records
            String selectSQL = "SELECT * FROM students";
            rs = stmt.executeQuery(selectSQL);
            System.out.println("All Students:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age"));
            }

            // 8. Transaction example
            conn.setAutoCommit(false); // Start transaction
            try {
                String transInsertSQL = "INSERT INTO students (name, age) VALUES (?, ?)";
                pstmt = conn.prepareStatement(transInsertSQL);

                pstmt.setString(1, "David");
                pstmt.setInt(2, 23);
                pstmt.executeUpdate();

                pstmt.setString(1, "Eve");
                pstmt.setInt(2, 22);
                pstmt.executeUpdate();

                // Uncomment to test rollback
                // int error = 1 / 0;

                conn.commit();
                System.out.println("Transaction committed successfully.");
            } catch (Exception e) {
                conn.rollback();
                System.out.println("Transaction rolled back due to error: " + e.getMessage());
            } finally {
                conn.setAutoCommit(true); // Restore default
            }

            // 9. Final display
            rs = stmt.executeQuery("SELECT * FROM students");
            System.out.println("Final Students Data:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getInt("age"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 10. Close resources
            try {
                if (rs != null)
                    rs.close();
            } catch (Exception e) {
            }
            try {
                if (stmt != null)
                    stmt.close();
            } catch (Exception e) {
            }
            try {
                if (pstmt != null)
                    pstmt.close();
            } catch (Exception e) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
            }
            System.out.println("Resources closed.");
        }
    }
}
