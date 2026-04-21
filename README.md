# Othello (Reversi) Game in Java

This repository contains the implementation of the classic **Othello (Reversi)** board game in Java as a **console-based application**, applying fundamental concepts in data structures, game logic, and algorithmic problem solving.
This project was developed as part of the **Data Structures** course and focuses on applying:

- 2D array manipulation
- Basic search logic
- State management
- Object-oriented design
- Game rule implementation

It represents an early programming project centered on translating algorithmic thinking into a fully functional interactive application.

The game is implemented as **Player vs Computer**, using a **6×6 board** (as required by the assignment), with the option to switch to the standard **8×8 board** by modifying a single parameter in the source code.

---

## 📌 Overview

**Othello (Reversi)** is a two-player strategy board game in which players take turns placing pieces on the board in order to capture (flip) their opponent’s pieces.

A move is valid only if it encloses one or more opponent pieces in one or more directions (horizontal, vertical, or diagonal).  
All enclosed pieces are flipped to the current player's symbol.

This implementation includes:

- Full Othello game logic in Java
- Console-based gameplay
- Human player (**X**) vs Computer (**O**)
- Move validation and directional flipping
- Automatic score calculation
- Simple computer opponent based on valid move generation
- Configurable board size (e.g. **6×6** or **8×8**)

The project focuses on implementing the core mechanics of the game using basic data structures and algorithms.

---

## 🎮 Features

- **Player vs Computer gameplay**
- **6×6 board**
- Easy switch to **8×8 standard Othello** by changing `N`
- Full move validation
- Piece flipping in all 8 directions
- Turn-based game loop
- Score tracking
- Game-over detection
- Basic computer opponent using generated valid moves

---

## 📂 Project Structure

```
othello
│
├── src/
│ ├── Board.java     # Main game logic and program entry point
│ └── Move.java      # Move representation (x, y coordinates)
│
├── .gitignore
├── README.md
```

### Main Classes

### `Move.java`
Defines a move using:

- Horizontal coordinate (`x`)
- Vertical coordinate (`y`)

Includes:

- Constructors
- Getters
- Move object representation used by the computer player

---

### `Board.java`
Implements the main game logic:

- Board initialization
- Move validation
- Piece flipping
- Score calculation
- Move generation
- Computer move selection
- Game loop
- Console interaction
- End-of-game logic

The board is represented internally using a:

```java
char[][]
```

where:

- `X` → Human player  
- `O` → Computer  
- `.` → Empty position

---

## 🛠️ Technologies & Tools Used

- **Java**
- **Object-Oriented Programming (OOP)**
- **Java Arrays**
- **ArrayList**
- **Scanner**
- **Console-based input/output**

---

## ▶️ How to Run

- Make sure you have the **Java Development Kit (JDK)** installed:

- Compile:

```bash
    javac src/Board.java src/Move.java
```

- Run:

```bash
    java -cp src Board
```

---

## 🚀 Possible Extensions

Possible future improvements include:

- Implementing a smarter computer opponent with more advanced decision-making logic
- Developing a graphical (GUI) version of the game

---

## 📝 Notes

- The board size is currently set to **6×6**, following the original course specification.
- To play standard Othello, simply change:

```java
N = 6
```

to:

```java
N = 8
```

in the main function in `Board.java`.

- The current computer player uses a simple strategy by selecting randomly (actually the first) from available valid moves.
