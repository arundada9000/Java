import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new Button("Top Button"));
        borderPane.setLeft(new Button("Left Button"));
        borderPane.setCenter(new Button("Center Button"));
        borderPane.setRight(new Button("Right Button"));
        borderPane.setBottom(new Button("Bottom Button"));

        Scene scene = new Scene(borderPane, 400, 300);
        primaryStage.setTitle("BorderPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
