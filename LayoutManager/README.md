# LayoutManager

Swing **layout manager** demos. Each file shows one layout strategy, several combine them with menus, toolbars and popups.

| File | Shows |
| --- | --- |
| `FlowLayoutDemo.java` | `FlowLayout` |
| `GridLayoutDemo.java` | `GridLayout` |
| `BorderLayoutAdvancedDemo.java` | `BorderLayout` with padding |
| `GridBagLayoutDemo.java` | `GridBagLayout` + `GridBagConstraints` |
| `GroupLayoutDemo.java` | `GroupLayout` (parallel/sequential groups) |
| `NullLayoutDemo.java` | Absolute positioning with `setLayout(null)` |
| `NestedLayoutDemo.java` | Nested panels with different layouts |
| `AllControlsDemo.java` | Every common Swing control in one window |
| `AdvancedSwingDemo.java` | Advanced Swing controls and interactions |
| `MenuToolbarPopupDemo.java` | Menus, toolbars and popup menus combined |

## Requirements
- JDK 8+

## Run
```bash
javac FlowLayoutDemo.java
java FlowLayoutDemo
```
Each file has its own `main` method, replace the file name to run another demo. A window will open.