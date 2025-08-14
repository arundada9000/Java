# SpeechRecognizer

A **real-time speech-to-text** app built with [Vosk](https://alphacephei.com/vosk/), Java and a microphone, packaged as a Maven project.

## What it does
- Lists audio mixers that support 16 kHz, 16-bit, mono input
- Opens the first usable microphone
- Streams audio into a Vosk recognizer and prints partial + final transcription to the console

## Requirements
- **JDK 17+**
- **Apache Maven 3.6+** (dependencies are pulled from Maven Central: `org.vosk:vosk:0.3.38`, `net.java.dev.jna:jna:5.12.1`)
- A downloaded **Vosk model** (see below)
- A working microphone

## Setup

1. Download the small English model:
   ```
   https://alphacephei.com/vosk/models/vosk-model-small-en-us-0.15.zip
   ```
2. Unzip it so the model folder sits at `models/vosk-model-small-en-us-0.15`
   (the `App.java` looks for the model at that relative path).

> The model is intentionally **git-ignored** (tens of MB), download it, do not commit it.

## Run

```bash
cd SpeechRecognizer
mvn compile exec:java -Dexec.mainClass=com.example.speech.App
```

Start speaking; transcribed lines appear in the console. `LibVosk.init()` is commented out at the top of `App.java`, uncomment it if your native library path needs it.

## Files

```
SpeechRecognizer/
  pom.xml                     Maven build file (deps, Java 17)
  src/main/java/com/example/speech/App.java   Main application
  src/test/java/com/example/speech/AppTest.java
  models/                     Vosk model (git-ignored, download it)
  libs/                       Optional local jars (git-ignored, Maven resolves deps)
```

## Notes
- `target/` is Maven output and is git-ignored.
- Running `mvn exec:java` downloads the exec-maven-plugin automatically on the first run.