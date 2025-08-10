import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TextFieldExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        textField.setPromptText("Enter your name");
        Scene scene = new Scene(textField, 300, 100);
        primaryStage.setTitle("TextField Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
