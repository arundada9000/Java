# Space Invaders (standalone project)

A sprite-based **Space Invaders** implementation in Swing.

- `App.java`, entry point (creates the window).
- `SpaceInvaders.java`, game logic (aliens, bullets, collision).
- `*.png`, sprite assets (ship, alien variants).

## Requirements
- JDK 8+

## Run
**Must run from inside this folder** so the PNG assets resolve:

```bash
cd Games/space-invaders-java
javac App.java SpaceInvaders.java
java App
```

## Controls
- **Left / Right arrows**, move the ship
- **SPACE**, shoot
- **R**, restart after game over