# Practical

Programs written for **practical / lab assignments**.

| File | Topic |
| --- | --- |
| `RoomTest.java` | Inheritance: `Room` base class and `Bedroom` subclass (area and volume) |
| `Rectangle.java`, `Circle.java`, `Shape.java`, `Bedroom.java`, `Room.java` | Supporting classes for the demos above |
| `SimpleInterestCalculator.java` | Swing GUI that computes simple interest |
| `ArithmeticMenu.java` | Console menu with basic arithmetic operations |
| `EmployeeDatabase.java` | Manage an employee database (console) |
| `EmployeeDetailsForm.java` | Swing form that appends employee details to `employee_details.txt` |
| `InterfaceTest.java` | Interfaces and their implementations |

## Requirements
- JDK 8+

## Run
```bash
javac RoomTest.java
java RoomTest
```
Each file listed above has its own `main` method, replace the file name to run another program.

> `EmployeeDetailsForm.java` writes its output to `employee_details.txt` (git-ignored; it is generated at runtime).