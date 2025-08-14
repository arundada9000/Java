# Exam-Prep

Programs written while preparing for Java exams, covering the **core OOP and CS basics** the syllabus usually asks for.

## Object-Oriented Programming

| File | Topic |
| --- | --- |
| `classes.java` | Classes and objects, basic OOP usage |
| `constructor.java` | Constructors (default and parameterized) |
| `AbstractClass.java` | Abstract classes (`Shape`, `Circle`, `Rectangle`) |
| `Interface.java` | Interfaces and implementing classes |
| `MethodDispatch.java` | Dynamic method dispatch / runtime polymorphism (`A`, `B`, `C`) |
| `B.java`, `C.java`, `Circle.java`, `Rectangle.java`, `Shape.java`, `Volume.java`, `Distance.java`, `Box.java`, `Dog.java`, `Animal.java` | Supporting classes used by the demos above |

## Exceptions

| File | Topic |
| --- | --- |
| `ExceptionHandling.java` | `try` / `catch` / `finally` |
| `CustomException.java` | Custom exception classes |
| `InvalidAgeException.java`, `AgeNotValidException.java`, `Validate.java` | Custom validation exceptions (age check) |

## Threads and Concurrency

| File | Topic |
| --- | --- |
| `TestThread.java` | Extending `Thread` / implementing `Runnable` |
| `CoffeeShop.java` | `Runnable` + interface: concurrent coffee orders |
| `RestaurantSimulation.java` | Simulated restaurant with concurrent orders |
| `ChefOrder.java`, `CustomerOrder.java`, `CoffeeOrder.java`, `RestaurantTask.java` | Supporting classes for the simulations |

## Packages

| File | Topic |
| --- | --- |
| `mypackage/PackageCreation.java` | A package containing a public class |
| `UsePackage.java` | Importing and using that package |
| `one.txt`, `two.txt`, `magic.txt` | Sample text files used by file examples |

## Arrays / Misc

| File | Topic |
| --- | --- |
| `ArrayMethods.java` | Array utilities (search, min/max, print) |
| `Question.java` / `Question1.java` / `Question2.java` / `Question3.java` | Inner classes, loops and various practice questions |
| `program.java` | 2-D array input/display |
| `ToDoApp.java` | A small console to-do list |

## Run
```bash
javac MethodDispatch.java
java MethodDispatch
```
Each file named in the tables above has its own `main` method.

**One exception, the package demo:**
```bash
# The package must compile before use
javac -d . mypackage/PackageCreation.java
javac UsePackage.java
java UsePackage
```