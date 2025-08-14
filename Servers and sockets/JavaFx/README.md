# JavaFx

**JavaFX UI** layout and control demos. Each file is a complete JavaFX application.

| File | Shows |
| --- | --- |
| `ButtonExample.java` | `Button` + event handler |
| `LabelExample.java` | `Label` |
| `TextFieldExample.java` | `TextField` |
| `CheckBoxExample.java` | `CheckBox` |
| `RadioButtonExample.java` | `RadioButton` + `ToggleGroup` |
| `HyperlinkExample.java` | `Hyperlink` |
| `BorderPaneExample.java` | `BorderPane` layout |
| `GridPaneExample.java` | `GridPane` layout |
| `HBoxExample.java` | `HBox` layout |
| `VBoxExample.java` | `VBox` layout |
| `FlowPaneExample.java` | `FlowPane` layout |
| `FileChooserExample.java` | `FileChooser` |

## Requirements
- JDK 8 (JavaFX included) **or** JDK 11+ with the **JavaFX SDK** (JavaFX is no longer bundled with the JDK)
- Example (JDK 11+): `javac --module-path <javafx-sdk>\lib --add-modules javafx.controls ButtonExample.java`

## Run
```bash
javac ButtonExample.java
java ButtonExample
```
Each file opens its own window showing the demo component.