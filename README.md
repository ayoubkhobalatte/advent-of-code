# advent-of-code

Advent of Code solutions in Kotlin using Gradle.

## Project Structure

- `src/main/kotlin/com/adventofcode/` - Solution implementations
- `src/test/kotlin/com/adventofcode/` - Test cases

## Building and Testing

Build the project:
```bash
./gradlew build
```

Run all tests:
```bash
./gradlew test
```

Run tests for a specific day:
```bash
./gradlew test --tests "com.adventofcode.Day01Test"
```

Clean build artifacts:
```bash
./gradlew clean
```

## Requirements

- JDK 17 or higher
- Gradle (wrapper included)

## Current Solutions

- **Day 01**: Sum operations on lists
- **Day 02**: Product operations on lists