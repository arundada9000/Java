import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

public class CheckBoxExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        CheckBox checkBox = new CheckBox("Accept terms and conditions");
        Scene scene = new Scene(checkBox, 250, 100);
        primaryStage.setTitle("CheckBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
