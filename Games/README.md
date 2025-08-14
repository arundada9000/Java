# Games

Playable **Swing games** written for practice. Compile and run each game individually.

> **Tip:** Always run the games from inside the `Games` folder so resource files (images used by Pac-Man / Space Invaders) resolve correctly.

## Game list

| Game | File | Controls |
| --- | --- | --- |
| **Snake** | `SnakeGame.java` | Arrow keys to move, SPACE to start/restart |
| **Tetris** | `Tetris.java` | Left/Right move, Down soft drop, Up rotate |
| **Breakout** | `BreakoutGame.java` | Left/Right move paddle, SPACE start/restart |
| **Flappy Bird** | `FlappyBird.java` | SPACE to flap, SPACE to restart |
| **Space Invaders** | `space-invaders-java/` | Left/Right move, SPACE shoot, R restart |
| **Pac-Man** | `pacman-java/` | Arrow keys move |
| **Pong** | `PongGame.java` | W/S and Up/Down move paddles, SPACE start |
| **Minesweeper** | `Minesweeper.java` | Mouse click to reveal |
| **Frogger** | `Frogger.java` | Arrow keys to hop, R restart |
| **Dino Runner** | `DinoRunner.java` | SPACE/Up jump, SPACE start |
| **Tic-Tac-Toe** | `TicTacToe.java` | Click a cell to place your mark |

## Extras

- `TodoListApp.java`, a small Swing to-do list app (not a game but lives here).
- `CodeSnippetManager.java`, stores and searches code snippets in a Swing UI.

## Run (example)

```bash
cd Games
javac SnakeGame.java
java SnakeGame
```

## Standalone game projects

- [pacman-java](pacman-java/README.md), sprite-based Pac-Man with image assets.
- [space-invaders-java](space-invaders-java/README.md), sprite-based Space Invaders.