# Changelog

All notable changes to this repository are documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added
- Root `README.md` with repository overview, structure and run instructions.
- Per-folder READMEs for every topic folder (Action Events, Applet, AWT, Exam-Prep,
  File Handling, Games, IntelliJ Projects, JDBC, LayoutManager, Practical, Practice,
  Servers and sockets, SpeechRecognizer) and their subfolders.
- `IntelliJ Projects/` folder, containing the sources from the former
  "IntelliJ IDEA 2024.3.5\Java Projects\Java Project 1" workspace.
- Standard repository files: `LICENSE` (MIT), `CONTRIBUTING.md`,
  `SECURITY.md`, `CODE_OF_CONDUCT.md`, `.gitignore`.

### Changed
- Added a Java-specific `.gitignore` (compiled `.class` files, IDE folders,
  Maven `target/`, runtime data files, etc.).

### Removed
- All compiled `*.class` artifacts from the repository (144 files), plus other
  generated/runtime files (`target/`, `libs/`, `.vscode/`, `received_file.txt`,
  `employee_details.txt`, `tempCodeRunnerFile.java`).
- The now-orphaned `class1.class` (no source) and the duplicate `Practice/AddTwoNumbers`
  class artifacts.
- The external IntelliJ IDEA workspace folder
  `D:\IntelliJ IDEA 2024.3.5\Java Projects` was deleted after its source files were
  copied into `IntelliJ Projects/`.

> Prior history (before this cleanup) is available in the git history. The repository
> was previously only a loose collection of `.java` and `.class` files with no build tool.