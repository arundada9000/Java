# Action Events

AWT/Swing **event-handling** demos. Each file shows one kind of event listener.

| File | Demonstrates |
| --- | --- |
| `ActionEventDemo.java` | `ActionListener` via buttons, text fields |
| `EventHandlingDemo.java` | Basic event handling on a frame |
| `ItemEventDemo.java` | `ItemListener` on checkboxes / choice items |
| `KeyEventDemo.java` | `KeyListener`, key presses on the window |
| `MouseEventDemo.java` | `MouseListener` / `MouseMotionListener` |
| `FocusEventDemo.java` | `FocusListener` on text components |
| `WindowEventDemo.java` | `WindowListener`, window open/close events |

## Requirements
- JDK 8+ (AWT/Swing is part of the JDK, no extra dependencies)

## Run
```bash
javac KeyEventDemo.java
java KeyEventDemo
```
When the window is open, focus it and type / move the mouse to see the events printed in the console.