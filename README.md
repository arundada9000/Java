# Java

A personal collection of **Java practice programs, exercises, games and networking/server projects**, everything from AWT/Swing UI demos and exam preparation exercises to playable Swing games and a Vosk-powered speech recognizer.

> **Note:** This is a learning repository. It mixes standalone source files, Swing/AWT UI projects and a Maven-based speech-recognition app. The general-purpose Java files are not part of a single build; you compile and run each file individually (instructions below).

---

## Repository Structure

| Folder | What's inside |
| --- | --- |
| **Action Events/** | AWT event-handling demos (action, item, key, mouse, focus, window events) |
| **Applet/** | A classic Java applet example (`First.html` + `First.java`) |
| **AWT/** | AWT UI examples, dialogs, frames, menus, a student registration form |
| **Exam-Prep/** | OOP, interfaces, packages, exceptions, threads and small simulations (coffee shop, restaurant, to-do) |
| **File Handling/** | File I/O examples, read/write files, copy between files, vowel-word copier |
| **Games/** | Playable Swing games, Snake, Tetris, Breakout, Flappy Bird, Pong, Minesweeper, Frogger, Space Invaders, Pac-Man, Tic-Tac-Toe, Dino Runner |
| **IntelliJ Projects/** | Programs imported from a previous IntelliJ IDEA workspace (games, calculators, console programs) |
| **JDBC/** | JDBC database examples (scrollable results, interactive console app) |
| **LayoutManager/** | Swing layout manager demos, Grid, Border, Flow, GridBag, Group, null and nested layouts |
| **Practical/** | Practical-lab programs, room/rectangle classes, simple-interest calculator, employee details form and DB |
| **Practice/** | Swing practice, widgets, menus, dialogs, popups, color/file choosers and a small socket client/server |
| **Servers and sockets/** | Networking, TCP/UDP chat, file transfer, RMI "Hello", URL/HTTP, JavaMail, JavaFX UI samples |
| **SpeechRecognizer/** | Maven project, real-time speech-to-text using Vosk (mic input) |

Plus a handful of **root-level scratch programs** (`arrayAge`, `numberGame`, `primes`, `pattern`, `newFile`, `task`).

---

## Prerequisites

- **JDK 17+** (many programs use modern syntax: `switch` expressions, text blocks, pattern matching).
  Check with: `java -version`
- **No external build tool** is required for most folders, just the JDK.
- **SpeechRecognizer** additionally needs **Apache Maven** (and a downloaded Vosk model, see its [README](SpeechRecognizer/README.md)).

---

## Getting Started

Because these are standalone files, run them directly with `javac` + `java`:

```bash
# 1. Go into a folder
cd Games

# 2. Compile a single program
javac SnakeGame.java

# 3. Run it
java SnakeGame
```

### Compiling files that contain Unicode text (dice, emoji, etc.)
Some files (e.g. `IntelliJ Projects/DiceRolling.java`, `SpeechRecognizer`) contain non-ASCII characters. On Windows, tell the compiler to read them as UTF-8:

```bash
javac -encoding UTF-8 DiceRolling.java && java DiceRolling
```

### Running GUI programs
AWT/Swing programs (folders like **AWT**, **LayoutManager**, **Practice**) compile and run the same way, a window will appear when you run them:

```bash
cd LayoutManager
javac FlowLayoutDemo.java
java FlowLayoutDemo
```

### Running server/client pairs
Programs in **Servers and sockets/** run in two terminals, e.g. TCP chat:

```bash
# Terminal 1, server
cd "Servers and sockets/Chat server"
javac TCPChatServer.java && java TCPChatServer

# Terminal 2, client
javac TCPChatClient.java && java TCPChatClient
```

### Running the SpeechRecognizer (Maven)
```bash
cd SpeechRecognizer
mvn compile exec:java   # or: mvn package && java -jar target/SpeechRecognizer-1.0-SNAPSHOT.jar
```
Full setup (model download, dependencies) is in [SpeechRecognizer/README.md](SpeechRecognizer/README.md).

---

## Playing the Games

Each game is a Swing app with its own controls. Quick table:

| Game | Source | Controls |
| --- | --- | --- |
| Snake | `Games/SnakeGame.java` | Arrow keys |
| Tetris | `Games/Tetris.java` | Arrows + space/rotate |
| Breakout | `Games/BreakoutGame.java` | Mouse / arrow keys |
| Flappy Bird | `Games/FlappyBird.java` | SPACE |
| Space Invaders | `Games/space-invaders-java/` | Arrows + SPACE |
| Pac-Man | `Games/pacman-java/` | Arrow keys |
| Pong | `Games/PongGame.java` | Mouse / keys |
| Minesweeper | `Games/Minesweeper.java` | Mouse click |
| Frogger | `Games/Frogger.java` | Arrow keys |
| Dino Runner | `Games/DinoRunner.java` | SPACE |

See [Games/README.md](Games/README.md) for details.

---

## Folder Documentation

Each folder ships with its own README:

- [Action Events](Action%20Events/README.md)
- [Applet](Applet/README.md)
- [AWT](AWT/README.md)
- [Exam-Prep](Exam-Prep/README.md)
- [File Handling](File%20Handling/README.md)
- [Games](Games/README.md)
- [IntelliJ Projects](IntelliJ%20Projects/README.md)
- [JDBC](JDBC/README.md)
- [LayoutManager](LayoutManager/README.md)
- [Practical](Practical/README.md)
- [Practice](Practice/README.md)
- [Servers and sockets](Servers%20and%20sockets/README.md)
- [SpeechRecognizer](SpeechRecognizer/README.md)

---

## What Is Ignored (`.gitignore`)

Compiled artifacts and local/IDE files are **not** committed:

- `*.class` compiled bytecode
- `target/` (Maven output), `out/`, `bin/`
- IDE folders: `.idea/`, `*.iml`, `.vscode/`, `.project`, `.classpath`
- `SpeechRecognizer/libs/` (jars resolved by Maven) and `SpeechRecognizer/models/` (download the model separately)
- Runtime data files (`received_file.txt`, `employee_details.txt`)
- OS junk (`.DS_Store`, `Thumbs.db`), logs

---

## Contributing

Although this repo is mostly personal learning material, contributions are welcome, fixes, better comments, new games, or documentation improvements. See [CONTRIBUTING.md](CONTRIBUTING.md) and [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md).

## License

Distributed under the MIT License. See [LICENSE](LICENSE) for details.

## Changelog

See [CHANGELOG.md](CHANGELOG.md) for the version history.