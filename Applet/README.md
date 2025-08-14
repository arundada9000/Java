# Applet

A minimal classic **Java applet** example.

| File | Purpose |
| --- | --- |
| `First.java` | Applet that draws a welcome message / simple graphics |
| `First.html` | HTML page that embeds and runs the applet |

## Note
Applets were deprecated in Java 9 and **removed in Java 11**. You must use an older JDK (Java 8 or earlier) to run them, or use the `appletviewer` tool shipped with the old JDK.

## Run (with Java 8)
```bash
# Easiest: open the HTML page in a browser with the Java 8 plugin, or use appletviewer
appletviewer First.html
```
Or compiled manually first:
```bash
javac First.java
appletviewer First.html
```