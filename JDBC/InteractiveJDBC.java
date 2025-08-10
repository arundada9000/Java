// javac -cp ".;C:\Program Files\Java\mysql-connector-j-9.4.0\mysql-connector-j-9.4.0.jar" InteractiveJDBC.java
// java -cp ".;C:\Program Files\Java\mysql-connector-j-9.4.0\mysql-connector-j-9.4.0.jar" InteractiveJDBC

import java.sql.*;
import java.util.Scanner;

public class InteractiveJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root"; // change to your MySQL password

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                Scanner sc = new Scanner(System.in)) {

            // Create table if not exists
            String createTable = """
                    CREATE TABLE IF NOT EXISTS students_jdbc (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(50) NOT NULL,
                        age INT NOT NULL
                    )
                    """;
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTable);
            }

            while (true) {
                System.out.println("\n--- MENU ---");
                System.out.println("1. Insert Student");
                System.out.println("2. Update Student");
                System.out.println("3. Delete Student");
                System.out.println("4. View All Students");
                System.out.println("5. Batch Insert (Transaction)");
                System.out.println("6. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> insertStudent(conn, sc);
                    case 2 -> updateStudent(conn, sc);
                    case 3 -> deleteStudent(conn, sc);
                    case 4 -> viewStudents(conn);
                    case 5 -> batchInsert(conn, sc);
                    case 6 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();

        String sql = "INSERT INTO students_jdbc (name, age) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        }
    }

    private static void updateStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new age: ");
        int age = sc.nextInt();

        String sql = "UPDATE students_jdbc SET name=?, age=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) updated.");
        }
    }

    private static void deleteStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM students_jdbc WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) deleted.");
        }
    }

    private static void viewStudents(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students_jdbc";
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Student List ---");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.printf("%d | %s | %d%n", id, name, age);
            }
        }
    }

    private static void batchInsert(Connection conn, Scanner sc) throws SQLException {
        conn.setAutoCommit(false); // start transaction
        String sql = "INSERT INTO students_jdbc (name, age) VALUES (?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            System.out.print("How many students to insert? ");
            int count = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < count; i++) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter age: ");
                int age = sc.nextInt();
                sc.nextLine();

                ps.setString(1, name);
                ps.setInt(2, age);
                ps.addBatch();
            }

            ps.executeBatch();
            conn.commit(); // commit transaction
            System.out.println("Batch insert committed.");
        } catch (SQLException e) {
            conn.rollback(); // rollback if error
            System.out.println("Batch insert rolled back.");
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }
}
