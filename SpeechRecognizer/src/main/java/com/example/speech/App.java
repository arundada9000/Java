package com.example.speech;

import org.vosk.Model;
import org.vosk.Recognizer;
import org.vosk.LibVosk;

import javax.sound.sampled.*;

public class App {
    public static void main(String[] args) {
        // LibVosk.init();
        System.out.println("🧠 Vosk initialized");

        // Desired format: 16 kHz, 16‑bit, mono, little-endian
        AudioFormat format = new AudioFormat(16000f, 16, 1, true, false);
        Mixer.Info selectedMixer = null;

        System.out.println("Available mixers with supported TargetDataLine:");
        for (Mixer.Info info : AudioSystem.getMixerInfo()) {
            Mixer mixer = AudioSystem.getMixer(info);
            if (mixer.isLineSupported(new DataLine.Info(TargetDataLine.class, format))) {
                System.out.println("  ✓ " + info.getName());
                if (selectedMixer == null) {
                    selectedMixer = info;
                }
            }
        }

        if (selectedMixer == null) {
            System.err.println("❌ No mixer supports the required audio format.");
            System.exit(1);
        }

        try (Model model = new Model("models/vosk-model-small-en-us-0.15");
                TargetDataLine microphone = (TargetDataLine) AudioSystem.getMixer(selectedMixer)
                        .getLine(new DataLine.Info(TargetDataLine.class, format));
                Recognizer recognizer = new Recognizer(model, 16000)) {

            microphone.open(format);
            microphone.start();

            System.out.println("🎤 Started microphone input via mixer: " + selectedMixer.getName());

            byte[] buffer = new byte[4096];
            while (true) {
                int bytesRead = microphone.read(buffer, 0, buffer.length);
                if (bytesRead <= 0)
                    continue;

                // compute average volume
                int vol = 0;
                for (int i = 0; i < bytesRead; i++) {
                    vol += Math.abs(buffer[i]);
                }
                vol /= bytesRead;
                System.out.println("Mic Volume: " + vol);

                if (recognizer.acceptWaveForm(buffer, bytesRead)) {
                    System.out.println("✅ Result: " + recognizer.getResult());
                } else {
                    System.out.println("🕓 Partial: " + recognizer.getPartialResult());
                }
            }

        } catch (LineUnavailableException e) {
            System.err.println("❗ Microphone line unavailable: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("❗ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
