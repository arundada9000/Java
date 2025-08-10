// javac -cp ".;C:\Program Files\Java\mysql-connector-j-9.4.0\mysql-connector-j-9.4.0.jar" InteractiveJDBCApp.java
// java -cp ".;C:\Program Files\Java\mysql-connector-j-9.4.0\mysql-connector-j-9.4.0.jar" InteractiveJDBCApp

import java.sql.*;
import java.util.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class InteractiveJDBCApp {
    static final String URL = "jdbc:mysql://localhost:3306/testdb";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                Scanner sc = new Scanner(System.in)) {

            con.setAutoCommit(false); // Transaction start

            // Create table if not exists
            try (Statement stmt = con.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS employees (" +
                        "id INT PRIMARY KEY AUTO_INCREMENT, " +
                        "name VARCHAR(50), " +
                        "salary DECIMAL(10,2))");
            }

            while (true) {
                System.out.println("\n=== Employee Management Menu ===");
                System.out.println("1. Insert Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. View Employees (CachedRowSet)");
                System.out.println("6. SQL Escapes Example");
                System.out.println("7. Commit");
                System.out.println("8. Rollback");
                System.out.println("9. Exit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter salary: ");
                        double salary = sc.nextDouble();
                        try (PreparedStatement ps = con.prepareStatement(
                                "INSERT INTO employees(name, salary) VALUES(?, ?)")) {
                            ps.setString(1, name);
                            ps.setDouble(2, salary);
                            ps.executeUpdate();
                            System.out.println("Employee added.");
                        }
                        break;

                    case 2:
                        try (Statement stmt = con.createStatement(
                                ResultSet.TYPE_SCROLL_SENSITIVE,
                                ResultSet.CONCUR_UPDATABLE)) {
                            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
                            rs.beforeFirst();
                            while (rs.next()) {
                                System.out.println(rs.getInt("id") + " - " +
                                        rs.getString("name") + " - " +
                                        rs.getDouble("salary"));
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter employee ID: ");
                        int uid = sc.nextInt();
                        System.out.print("Enter new salary: ");
                        double newSal = sc.nextDouble();
                        try (PreparedStatement ps = con.prepareStatement(
                                "UPDATE employees SET salary=? WHERE id=?")) {
                            ps.setDouble(1, newSal);
                            ps.setInt(2, uid);
                            ps.executeUpdate();
                            System.out.println("Salary updated.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter employee ID to delete: ");
                        int did = sc.nextInt();
                        try (PreparedStatement ps = con.prepareStatement(
                                "DELETE FROM employees WHERE id=?")) {
                            ps.setInt(1, did);
                            ps.executeUpdate();
                            System.out.println("Employee deleted.");
                        }
                        break;

                    case 5:
                        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
                        crs.setUrl(URL);
                        crs.setUsername(USER);
                        crs.setPassword(PASS);
                        crs.setCommand("SELECT * FROM employees");
                        crs.execute();
                        System.out.println("CachedRowSet Data:");
                        while (crs.next()) {
                            System.out.println(crs.getInt("id") + " - " +
                                    crs.getString("name") + " - " +
                                    crs.getDouble("salary"));
                        }
                        break;

                    case 6:
                        System.out.println("Employees hired before current date:");
                        String dateQuery = "SELECT * FROM employees WHERE {fn CURDATE()} >= ?";
                        try (PreparedStatement ps = con.prepareStatement(dateQuery)) {
                            ps.setDate(1, java.sql.Date.valueOf("2000-01-01"));
                            ResultSet rs = ps.executeQuery();
                            while (rs.next()) {
                                System.out.println(rs.getString("name") + " - " +
                                        rs.getDouble("salary"));
                            }
                        }
                        break;

                    case 7:
                        con.commit();
                        System.out.println("Transaction committed.");
                        break;

                    case 8:
                        con.rollback();
                        System.out.println("Transaction rolled back.");
                        break;

                    case 9:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
