package mypackage;

public class PackageCreation {
    public void show() {
        System.out.println("This is a package.");
    }

    public static void clear() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder;

            if (os.contains("win")) {
                // For Windows
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                // For Unix/Linux/Mac
                processBuilder = new ProcessBuilder("clear");
            }

            // Start the process to clear the screen
            processBuilder.inheritIO().start().waitFor(); // Inherit IO streams and wait for process to finish

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------------------- Screen Cleared -------------------");
    }
}
