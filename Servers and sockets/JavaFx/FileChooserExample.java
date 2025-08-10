import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileChooserExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Open File");
        button.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            fileChooser.showOpenDialog(primaryStage);
        });

        Scene scene = new Scene(button, 200, 100);
        primaryStage.setTitle("FileChooser Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
