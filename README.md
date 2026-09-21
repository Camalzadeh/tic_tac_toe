# Tic-Tac-Toe

A two-player tic-tac-toe game played in the terminal. Java Lessons, task 2.

Players take turns entering a row and a column; the board is redrawn after every
move, and the game ends on three in a row or a full board.

## What it covers

- A `char[3][3]` board and the turn-alternation loop.
- Input validation with `Scanner` - out-of-range coordinates and non-numeric input
  are rejected and asked for again, rather than throwing.
- Win detection across rows, columns and both diagonals, plus the draw case.

## Running it

```bash
javac -d out src/Main.java
java -cp out Main
```

Enter moves as two numbers, `row column`, both 1-3 - for example `2 2` for the centre.

## Layout

- `src/Main.java` - the board, the rendering, the input loop and the win check.
