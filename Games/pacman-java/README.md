# Pac-Man

A sprite-based **Pac-Man** implementation in Swing.

- `App.java`, entry point (creates the window).
- `PacMan.java`, game logic (maze, movement, ghosts, pellets, power-food).
- `*.png`, sprite assets (Pac-Man directions, ghosts, cherry, power food, wall).

## Requirements
- JDK 8+

## Run
**Must run from inside this folder** so the PNG assets resolve:

```bash
cd Games/pacman-java
javac App.java PacMan.java
java App
```

## Controls
- **Arrow keys**, move Pac-Man
- Collect pellets and power food to eat ghosts