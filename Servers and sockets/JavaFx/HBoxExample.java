import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox hbox = new HBox(10); // 10px gap between buttons
        hbox.getChildren().addAll(
                new Button("Button 1"),
                new Button("Button 2"),
                new Button("Button 3"));

        Scene scene = new Scene(hbox, 300, 200);
        primaryStage.setTitle("HBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
