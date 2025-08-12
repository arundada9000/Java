# IntelliJ Projects

Programs imported from a previous **IntelliJ IDEA workspace** (`Java Project 1`). These are standalone console and Swing programs, each with its own `main` method.

## Program list

| File | Description |
| --- | --- |
| `BankingProgram.java` | Console banking menu, show balance, withdraw, deposit |
| `check.java` | Prints the integer value of the character `'0'` |
| `DiceRolling.java` | Rolls N dice, draws ASCII dice faces, prints the total |
| `excel_column_to_number.java` | Converts spreadsheet column letters (e.g. `AA`) to a number |
| `FlappyBird.java` | Flappy Bird game (Swing, SPACE to flap) |
| `Inclass.java` | Reads `x`, `y` and prints their sum |
| `Main.java` | Number-guessing game (1-100) with replay option |
| `Messing_with_Arrays.java` | Array exercises, max element, odd/even count, sorting |
| `OddOrEven.java` | Helper class with `isOddOrEven()`, **no** `main` method |
| `Prime.java` | Checks whether a number is prime |
| `rectangleArea.java` | Reads length and width, prints the rectangle area |
| `Revision.java` | Nested-loop demo plus an `Add` method |
| `Shiv.java` | Empty scratch file, no logic |
| `SimpleInterestCalculator.java` | Swing GUI that computes simple interest |
| `stringMethods.java` | String reverse, palindrome check, character count |
| `sumOfPrimes.java` | Sums 5 user-entered prime numbers |
| `Vowel.java` | Counts vowels in a word |

## Requirements
- JDK 14+ (`DiceRolling.java` uses switch expressions and text blocks)

## Run
```bash
cd "IntelliJ Projects"
javac -encoding UTF-8 DiceRolling.java   # UTF-8 needed for the ASCII-dice symbols
java DiceRolling
```
Replace the file name to run another program (`OddOrEven.java` has no `main`, it is used from `Revision`-style code).