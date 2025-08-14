# Contributing

Thanks for your interest in contributing to this repository. It is mostly personal
learning material, but improvements are very welcome.

## What is appreciated

- Bug fixes in existing programs
- Better algorithms or cleaner code (without changing program behavior)
- New small examples that fit an existing topic folder
- Documentation improvements, clearer comments, typo fixes

## Ground rules

- Do **not** commit generated files: `*.class`, `target/`, `out/`, IDE folders.
  The `.gitignore` already covers these, keep it that way.
- Keep programs self-contained: prefer files that run with `javac X.java && java X`
  over multi-module setups, unless the topic needs a build tool (e.g. SpeechRecognizer).
- Follow the existing style of the file you edit.

## How to run programs

Most programs are standalone:

```bash
cd <folder>
javac <File>.java
java <File>
```

See the root [README.md](README.md) for details.

## Making changes

1. **Fork** the repository and create a branch:
   ```bash
   git checkout -b fix/describe-the-change
   ```
2. Make your changes and verify they compile/run.
3. Commit with a clear message describing the change.
4. Push the branch and open a pull request.

## Pull request checklist

- Describe what the change does and why.
- Confirm the program(s) still run after your change.
- Confirm no generated files are part of the diff.

## Code of conduct

Be respectful. Please read our [Code of Conduct](CODE_OF_CONDUCT.md).