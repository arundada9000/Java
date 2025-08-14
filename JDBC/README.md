# JDBC

Examples demonstrating **JDBC (Java Database Connectivity)** with MySQL.

| File | Purpose |
| --- | --- |
| `JDBCFullExample.java` | Full CRUD: connect, create table, insert/update/delete/select, transactions, resource cleanup |
| `InteractiveJDBC.java` | Interactive console menu: insert, update, delete, view, batched transactions |
| `InteractiveJDBCApp.java` | Employee-management console app with transactions, CachedRowSet and SQL escapes |

## Requirements
- JDK 8+
- A running **MySQL** server with a `testdb` database
- The **MySQL Connector/J** jar (e.g. `mysql-connector-j-9.4.0.jar`), downloaded from the [MySQL website](https://dev.mysql.com/downloads/connector/j/)

## Configure
Each file has connection constants at the top. Adjust them to your setup:

```java
String url = "jdbc:mysql://localhost:3306/testdb";
String user = "root";
String password = "root";   // your MySQL password
```

## Run
The connector jar must be on the classpath:

```bash
cd JDBC

# Windows (adjust the jar path to your own)
javac -cp ".;C:\path\to\mysql-connector-j-9.4.0.jar" JDBCFullExample.java
java  -cp ".;C:\path\to\mysql-connector-j-9.4.0.jar" JDBCFullExample
```

```bash
# Linux / macOS
javac -cp ".:/path/to/mysql-connector-j-9.4.0.jar" JDBCFullExample.java
java  -cp ".:/path/to/mysql-connector-j-9.4.0.jar" JDBCFullExample
```

> The connector jar is intentionally **not** committed to this repo, download it first.